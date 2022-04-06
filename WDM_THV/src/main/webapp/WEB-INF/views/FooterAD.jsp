<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


 </div>
    <script>
         var pop = document.getElementById("log");
        function ocllog() {
            pop.style.display="block";    
        }
        function close_log(){
            pop.style.display="none";
        }
        function Logout() {
			if(confirm("Bạn có muốn đăng xuất không ?")==true){
				location.href="./logout";
			}
		}
    </script>

</body>

</html>