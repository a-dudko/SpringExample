function MapWrapper() 
{
    var _this = this;
    this.map = null;
    this.setMarker = null;
    this.geocoder = null;
    this.markerClusterer = null;

    this.centerX =  53.9039; //��������� ���������� - ����� ������
    this.centerY = 27.5557;

    var retAddress = "";
    this.init = function () {
        //�������������� Geocoder
        if (_this.geocoder == null) {
            _this.geocoder = new google.maps.Geocoder();
        }
        //�������������� �����
        if (_this.map == null) {
            var latlng = new google.maps.LatLng(_this.centerX, _this.centerY);
            var myOptions = {
                zoom: 8,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            _this.map = new google.maps.Map(document.getElementById("Map"),
            myOptions);
        }

        //�� ������ Ok
        $("#submit").unbind("click");
        $("#submit").click(function () 
        {
            _this.setMapToCity();
        });
        //��� �� enter � ���� ������ ������������� ����� �� ����� + ������ ������� �� ��������
        $("#address").unbind("keypress");
        $("#address").keypress(function (e) {
            var code = (e.keyCode ? e.keyCode : e.which);
            if (code == 13) {
                _this.setMapToCity();
            }
        });

        $(".input_city").show();
        $(".address_list").hide();
        $(".info-put-marker").hide();
        $(".info-upload-picture").hide();
        $(".save-button").hide();
        //�� ������ ��������� - ��������� � �� �� ���� ����� �� �����
        $(".save-button").unbind("click");
        $(".save-button").click(function () {
            _this.SaveToDB();
        });

        _this.initUploader();
        _this.getMarkers();
    }
    
    //���������� ����� �� ����� 
    this.setMapToCity = function () {
        var address = $("#address").attr("value");

        _this.geocoder.geocode({ 'address': address }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                _this.map.setCenter(results[0].geometry.location);
                //���������� Zoom ����� �������, ����� ����� ��� ������� ����
                _this.map.setZoom(_this.getZoom(results[0].geometry.viewport));
                //� ��������� ������ ��� ������� ������
                _this.addMarker();
                $(".info-put-marker").show();
            } else {
                alert("����� ���-�� �� ���, ������ ���: " + status);
            }
        });
    }

    //���������� �������� Zoom �� �������� 
    this.getZoom = function (bounds) {

        var width = $(".map").width();
        var height = $(".map").height();

        var dlat = Math.abs(bounds.getNorthEast().lat() - bounds.getSouthWest().lat());
        var dlon = Math.abs(bounds.getNorthEast().lng() - bounds.getSouthWest().lng());

        var max = 0;
        if (dlat > dlon) {
            max = dlat;
        } else {
            max = dlon;
        }

        // Center latitude in radians
        var clat = Math.PI * Math.abs(bounds.getSouthWest().lat() + bounds.getNorthEast().lat()) / 360.;

        var C = 0.0000107288;
        var z0 = Math.ceil(Math.log(dlat / (C * height)) / Math.LN2);
        var z1 = Math.ceil(Math.log(dlon / (C * width * Math.cos(clat))) / Math.LN2);

        return 18 - ((z1 > z0) ? z1 : z0);
    }

    //�������� ������
    this.addMarker = function () {
        if (_this.setMarker != null) {
            _this.setMarker.setMap(_this.map);
            _this.setMarker.setPosition(_this.map.getCenter());
        } else {
            _this.setMarker = new google.maps.Marker({
                map: _this.map,
                draggable: true,
                animation: google.maps.Animation.DROP,
                position: _this.map.getCenter()
            });
            google.maps.event.addListener(_this.setMarker, 'click', _this.toggleBounceMarker);
            //��� ��������� ����������� ������� ���������� ������� 
            google.maps.event.addListener(_this.setMarker, 'dragend', _this.markerPositionChanged);
        }
    }


    //��� ����� �� ������ �� ����� ���������� � ���������� ���� ������ ����� ��� ��������
    this.toggleBounceMarker = function() {
        if (_this.setMarker.getAnimation() != null) {
            _this.setMarker.setAnimation(null);
        } else {
            _this.setMarker.setAnimation(google.maps.Animation.BOUNCE);
        }
    }

    //�������� ���������� � ���������� � ��������������
    this.markerPositionChanged = function () {
        var latlng = _this.setMarker.getPosition();
        _this.GetInfo(latlng);
    }

    //��������� ������ �� 
    this.GetInfo = function (latlng) 
    {
        _this.geocoder.geocode({ 'latLng': latlng, 'language' : 'ru' }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                _this.map.setCenter(results[0].geometry.location);
                _this.SetAddresses(results);
            } else {
                alert("����� ���-�� �� ���, ������ ���: " + status);
            }
        });
    }

    //��������� �������� ������
    this.SetAddresses = function (results) {
        $(".address_list").show();
        $(".address_list").empty();

        var addressText = _this.ComposeAddress(results[0]);

        var address = $("<div>").attr("class", "address").text(addressText);
        var obj = $("<div>").attr("class", "item").append(address);
        $(".address_list").append(obj);
        $(".info-upload-picture").show();
        $(".upload-picture").show();
        $(".picture").empty();
    }

    //��������� ������ ������ �� ������� ����������
    this.ComposeAddress = function (item) {
        retAddress = "";
        $.each(item.address_components, function (i, address_item) {
            var isOk = false;
            $.each(address_item.types, function (j, typeName) {
                //�� ����� ����� �������� ������ ����� � ������ (������) - ����� ����� ����� � administrative_level_2
                if (typeName != "street_address" && typeName != "locality") {
                    isOk = true;
                }
            });
            if (isOk) {
                if (retAddress == "") {
                    retAddress = address_item.long_name;
                } else {
                    retAddress = retAddress + ", " + address_item.long_name;
                }
            }
        });
        return retAddress;
    }

}


$().ready(function () {
    var mapWrapper = new MapWrapper();
    mapWrapper.init();
});