<%@include file="../header.jsp" %>



<h1>Enquiries</h1>
<form method = "post" action="enquiry">
    <div class="form-group" >
        <label>First Name</label>
        <input type="text" name="first_name" class="form-control">
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input type="text" name="last_name" class="form-control">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="text" name="email" class="form-control">
    </div>
    <div class="form-group">
        <label>Contact No.</label>
        <input type="number" name="contact_no" class="form-control" >
    </div>
    <div class="form-group">
        <label>Message</label>
        <textarea name="message" class="form-control"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Send</button>


</form>
</div>

</body>
</html>
