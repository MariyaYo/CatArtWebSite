<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/Background.css"></link>
	<link rel="stylesheet" type="text/css" href="../css/FrontPage.css"></link>
	<link rel="stylesheet" type="text/css" href="../css/PhotoNormal.css"></link>
	<link rel="stylesheet" type="text/css" href="../css/buttons.css"></link>
</head>
	<dody>
		<jsp:include page="BackgroundLoged.jsp" />
			<div>
				<ul>
					<li class = "floatLeft">
						<h4>
							<ul>
								<li class="firstInLine"><h3 class= "buttonColor">SORT</h3></li>
								<li> <a href="../ImgWithMostComments"><h3 class= "buttonColor">What's Hot</h3></a></li>
								<li> <a href="../ImgWithNoCommentsServlet"><h3 class= "buttonColor">Undiscovered</h3></a></li>
								<li> <a href="../ImgWithMostRaiting"><h3 class= "buttonColor">Most Stars</h3></a></li>
								<li> <a href="../ImgAlphabeticByUser"><h3 class= "buttonColor">Alphabetic</h3></a></li>
								<li> <a href="../ImgLastUploadedServlet"><h3 class= "buttonColor">Newest</h3></a></li>
								<li class="firstInLine"><h3 class= "buttonColor">CATEGORIES  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp</h3></li>
								<li>
								 	<form action="../ShowImgGenre">
										<button type="submit" ><h3 class= "buttonColor">Photo</h3></button>
										<input type="hidden" name="genre" value="PHOTO" />
									</form>
								 </li>
								<li> 
								 	<form action="../ShowImgGenre"> 
										<button  type="submit" name = "genre" value="DIGITAL"><h3 class= "buttonColor">Digital</h3></button>
									</form>							
								</li>
								<li> 
									<form action="../ShowImgGenre">
										<button  type="submit" name = "genre" value="TRADITIONAL"><h3 class= "buttonColor">Traditional</h3></button>
									</form>	
								</li>
								<li> 
									<form action="../ShowImgGenre">
										<button  type="submit" name = "genre" value="CRAFTS"><h3 class= "buttonColor">Crafts</h3></button>
									</form>	
								</li>
								<li> 
									<form action="../ShowImgGenre">
										<button  type="submit" name = "genre" value="COMICS"><h3 class= "buttonColor">Comics</h3></button>
									</form>	
								</li>
								<li> 
									<form action="../ShowImgGenre" >
										<button  type="submit" name = "genre" value="FANART"><h3 class= "buttonColor">FanArt</h3></button>
									</form>
								</li>
								<li class="lastInLine">
									<form action="../ShowImgGenre">
										<button  type="submit" name = "genre" value="SCETCH"><h3 class= "buttonColor">Scetch</h3></button>
									</form>
								</li>
							</ul>
					</h4>
				</li>
				<li> 
  				<% for(int i =1; i< 13 ; i++){	%>	
					<form action="../ViewImg">
				 	 	<input class = "firstPic" type="image" src="../DB_IMG/<%=i%>.jpg" alt="Submit">
						<input type="hidden" name = "imgNum" value="<%=i++%>">
					</form>
					<% 	}	%>	
				</li>
			</ul>
		</div>
	</body>
</html>