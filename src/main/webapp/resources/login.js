function formValidation(f)
{
  var uname = document.logging.userName;
  var upass = document.logging.userPassword;
  
  
  if(username_validation(uname))
  {
    if(userpass_validation(upass))
    {
    	f.submit();
    }
  }
  return false;

} 

function username_validation(uname)
{
  var uname_len = uname.value.length;
  if (uname_len == 0)
  {
    alert("UserName should not be empty");
    uname.focus();
    return false;
  }
  return true;
}

function userpass_validation(upass)
{
  var upass_len = upass.value.length;
  if (upass_len == 0)
  {
    alert("Password should not be empty");
    upass.focus();
    return false;
  }
  return true;
}