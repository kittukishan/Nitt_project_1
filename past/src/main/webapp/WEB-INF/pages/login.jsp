
<div class="modal fade" id="LoginModal" role="dialog">
<div class="modal-dialog">
 <div class="modal-content">
 
 <div class="modal-header">
<h2>
Welcome login
<button type="button" class="close" data-dismiss="modal">&times;</button>
</h2>

</div>

<form action="j_spring_security_check" method="post">
<div class="labels" align="center">
<h3><span class="label label-primary">Username</span></h3><input type="text" name="j_username" required>
</div>
<span></span>
<div class="labels" align="center">
<h3><label class="label label-primary">
Password
</label></h3>
<input type="password" name="j_password" required>
</div>
<!-- <a href="loginchk" style="color:green;text-decoration: none;"><b><h3>login</h3></b></a> -->
<!-- <input type="submit" value="Login"> -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning " data-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-success" >Login</button>
      </div>
</form>

</div>
</div>
</div>

