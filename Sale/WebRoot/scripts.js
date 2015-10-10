function focus(str)
{
	document.getElementById(str).focus();
}

function read()
{
	var value = document.getElementById("code").value;
	if(value.length == 28)
		alert(value);
}