<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cherry Brown</title>
<link href="<%=request.getContextPath()%>/css/template1/fastquote.css"
	rel="stylesheet" type="text/css" />
	


<%-- <script  type="text/javascript"   src="<%=request.getContextPath()%>/js/slideprepare.js"></script> --%>

<script type="text/javascript">
var image1=new Image();
image1.src="<%=request.getContextPath()%>/images/template1/hotelpic1.jpg";
var image2=new Image();
image2.src="<%=request.getContextPath()%>/images/template1/hotelpic2.jpg";
var image3=new Image();
image3.src="<%=request.getContextPath()%>/images/template1/hotelpic3.jpg";
var image4=new Image();
image4.src="<%=request.getContextPath()%>/images/template1/hotelpic4.jpg";
var image5=new Image();
image5.src="<%=request.getContextPath()%>/images/template1/hotelpic5.jpg";
var image6=new Image();
image6.src="<%=request.getContextPath()%>/images/template1/hotelpic6.jpg";
var image7=new Image();
image7.src="<%=request.getContextPath()%>/images/template1/hotelpic7.jpg";


</script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
</head>
<body>

<%-- <tiles:insertAttribute name="header" />	 --%>
	<div id="page">
		
			<div id="page-content-area">
			<tiles:insertAttribute name="header" />
				
				<div style="float: right;"><b>English|French</b></div>
				
				<tiles:insertAttribute name="menu" />
				<br />
			<div id="imageslider">
				<img src="<%=request.getContextPath()%>/images/template1/hotel1.jpg" name="slide" width=100% height=300 >
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/slideshow.js"></script>
  </div>
<div id="bodycontent">
				<tiles:insertAttribute name="body" />
				</div>
			</div>
		
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
