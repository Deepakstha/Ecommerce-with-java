<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<style>
nav{
display:flex;
background-color: white;
}
img{
    width: 80px;
    height: auto;
}
.navmenu{
    display: flex;
    list-style: none;
}
.navmenu a{
    color: #2c2c2c;
    font-size: 16px;
    text-transform: capitalize;
    padding: 10px 20px;
    font-weight: 400;
    transition: all .42s ease;
}
.navmenu a:hover{
    color: #EE1C47;
}
.nav-icon{
    display: flex;
    align-items: center;
}
.nav-icon i{
    margin-right: 20px;
    color: #2c2c2c;
    font-size: 25px;
    font-weight: 400;
    transition: all .42s ease;
}
.nav-icon i:hover{
    transform: scale(1.1);
    color: #EE1C47;
}
.main-btn{
    display: inline-block;
    color: #111;
    font-size: 16px;
    font-weight: 500;
    text-transform: capitalize;
    border: 2px solid #111;
    padding: 12px 25px;
    transition: all .42s ease;
}
.main-btn:hover{
    background-color: #000;
    color: #fff;
}

</style>


<nav>
<a href="#" class="logo"><img src="${pageContext.request.contextPath}/image/logo.png" alt=""></a>
<ul class="navmenu">
        	
            <li><a href="Home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayCart">View Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayOrdersList">View Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/EditProfile">Edit profile</a></li>

            <c:choose>
            	<c:when test="${sessionScope.loggedInEmail == null }">
            		<li><a href="${pageContext.request.contextPath}/views/Login.jsp">Log In</a></li>
            		<li><a href="${pageContext.request.contextPath}/views/Signup.jsp">Sign Up</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="Logout">Log Out</a></li>
            	</c:otherwise>
            </c:choose>     
            <li>
            	<form action="" style="gap: 5px;">
            		<input type="search" name="search" style="border:1px solid;
	border-radius:3px;
	width:200px;
	height:50px;
	padding-left:10px;
	font-size:16px;" placeholder="search" >
            		<button type="submit" class="main-btn"  > Search</button>
            	</form>
            </li>       
            
</ul></nav>

<script >
const header = document.querySelector("header");

window.addEventListener ("scroll", function(){
    header.classList.toggle ("sticky", this.window.scrollY > 0);
})

let menu = document.querySelector('#menu-icon');
let navmenu = document.querySelector('.navmenu');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navmenu.classList.toggle('open');
}
</script>