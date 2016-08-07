<html>
<head>
<script type="text/javascript">
function ctck()
{
var sds = document.getElementById("dum");
if(sds == null){alert("You are using a free package.\n You are not allowed to remove the tag.\n");}
}

</script>
</head>
<body>
<form name="form1" method="post" action="validate.jsp">
<table border="1" width="380" align="center" cellspacing="2" cellpadding="0" bgcolor="#A4EEFF"><TR><TD>
<table bgcolor="" align="center">
<tr> <td align="center" colspan="2"><img src="Cap_Img.jsp"><br><br>
<input type="button" value="Refresh Image" onClick="window.location.href=window.location.href"></td></tr>
<tr>
<td align="center"> Please enter the string shown in the image.</td><tr>
<td align="center"><input name="number" type="text"></td><tr>
<td align="center">
<input name="Submit" type="submit" value="Submit"></td> </tr>
<tr>
               <td width=100% align=right>
                    <a style="color: green; font-size: 11px; text-decoration: none; " id="dum" href="http://www.hscripts.com">Tool by - &copy; hscripts.com </a>
               </td>
           </tr>
</table>
</TD></TR></table>

</form>
<script language="javascript">
document.onload = ctck();
</script>
</body>
</html>
