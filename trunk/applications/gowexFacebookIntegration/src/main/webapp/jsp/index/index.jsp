<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:fb="http://www.facebook.com/2008/fbml">

<body>
<h2>Hello World!</h2>

<div id="fb-root"></div>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script>
         FB.init({ 
            appId:'149360635129769', cookie:true, 
            status:true, xfbml:true 
         });
      </script>

<fb:login-button onlogin="alert('Authenticated!');">Login with Facebook</fb:login-button>


<br/>

<iframe
	src="https://www.facebook.com/plugins/registration.php?
             client_id=113869198637480&
             redirect_uri=http%3A%2F%2Fdevelopers.facebook.com%2Ftools%2Fecho%2F&
             fields=name,birthday,gender,location,email"
	scrolling="auto" frameborder="no" style="border: none"
	allowTransparency="true" width="100%" height="330"> </iframe>

</body>
</html>
