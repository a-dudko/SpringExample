function formValidation(f)
{
  var etitle = document.new_event.eventTitle;
  
  if(eventTitle_validation(etitle))
  {
    f.submit();
  }
  return false;

} 

function eventTitle_validation(etitle,mx,my)
{
  var etitle_len = etitle.value.length;
  if (etitle_len == 0)
  {
    alert("Event title should not be empty");
    ulogin.focus();
    return false;
  }
  return true;
}