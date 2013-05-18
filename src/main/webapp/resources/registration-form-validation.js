function formValidation()
{
  var ulogin = document.registration.userLogin;
  var passid = document.registration.passid;
  var reppassid = document.registration.reppassid;
  var uname = document.registration.username;
  var uage = document.registration.age;
  var uemail = document.registration.email;
  var umsex = document.registration.msex;
  var ufsex = document.registration.fsex; 
  
  if(userid_validation(ulogin,5,12))
  {
    if(passid_validation(passid,7,12))
    {
     if(reppassid_validation(reppassid, passid))
     {
      if(allLetter(uname))
      {
        if(alphanumeric(uage))
        { 
        	if(ValidateEmail(uemail))
              {
                if(validsex(umsex,ufsex))
                {
                }
              } 
        }
      }
    }
    }
  }
  return false;

} 

function userid_validation(ulogin,mx,my)
{
  var ulogin_len = ulogin.value.length;
  if (ulogin_len == 0 || ulogin_len >= my || ulogin_len < mx)
  {
    alert("User login should not be empty / length be between "+mx+" to "+my);
    ulogin.focus();
    return false;
  }
  return true;
}

function reppassid_validation(reppassid,passid)
{
  if (reppassid.value != passid.value)
  {
    alert("Passwords should be equal");
    reppassid.focus();
    return false;
  }
  return true;
}

function passid_validation(passid,mx,my)
{
  var passid_len = passid.value.length;
  if (passid_len == 0 ||passid_len >= my || passid_len < mx)
  {
    alert("Password should not be empty / length be between "+mx+" to "+my);
    passid.focus();
    return false;
  }
  return true;
}

function allLetter(uname)
{ 
  var letters = /^[A-Za-z ]+$/;
  if(uname.value.match(letters))
  {
    return true;
  }
  else
  {
    alert('Username must have alphabet characters only');
    uname.focus();
    return false;
  }
}

function alphanumeric(uage)
{ 
  var letters = /^[0-9a-zA-Z]+$/;
  if(uadd.value.match(letters))
  {
	  if (uadd.value > 0 && uadd.value < 100)
		  return true;
	  else {
		  alert('User age must have alphanumeric characters only not greater than 100');
		  uadd.focus();
		  return false;
	  }
  }
  else
  {
    alert('User address must have alphanumeric characters only');
    uadd.focus();
    return false;
  }
}

function ValidateEmail(uemail)
{
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if(uemail.value.match(mailformat))
  {
    return true;  
  }
  else
  {
    alert("You have entered an invalid email address!");
    return false; 
  }
} 

function validsex(umsex,ufsex)
{
  x=0;

  if(umsex.checked) 
  {
    x++;
  }
  if(ufsex.checked)
  {
    x++;  
  }

  if (x==2)
  {
    alert('Both Male/Female are checked');
    ufsex.checked=false
    umsex.checked=false
    umsex.focus();
    return false;
  }

  if(x==0)
  {
    alert('Select Male/Female');
    umsex.focus();
    return false;
  }
  else
  {
    alert('Form Succesfully Submitted');
    window.location.reload()
    return true;
  }
}