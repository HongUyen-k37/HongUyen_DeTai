
	
		<!-- content -->
		<div id="content" class=" row ">
			
<div class="col-md-9 main-content">
	<div class="numbered-list">
		<h3>XỬ LÝ BÀI THI</h3>
		<h4 style="margin-left: 100px;">Phòng thi</h4>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Số hiệu phòng thi</th>
					<th>Số lượng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>01</td>
					<td>25</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="details-list">
		<h3>Danh sách các thí sinh dự thi</h3>
		<div class="main-list">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số báo danh</th>
					<th>Họ đệm</th>
					<th>Tên</th>
					<th>Ngày sinh</th>
					<th>Xử lý thi</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>001</td>
					<td>Trần Thị Hồng</td>
					<td>Uyên</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>002</td>
					<td>Trần Nữ Như</td>
					<td>Quỳnh</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>003</td>
					<td>Phạm Như Ngọc</td>
					<td>Tuấn</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
			</tbody>
			</table>
			<div class="totalCandidates">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success" name='execute' style="margin-left: 100px;">In Danh sách</button>
			</div>
		</div>
	</div>
</div>

<div class="col-md-3 contentNav">
	<div class="nameuser">
	</div><!-- end nameuser -->
	<h3>Thông tin kì thi</h3>
	<div class="main-nav">
	<form method="post" action="home.php">
		<div class="form-group">
		<label for="study">Ngành:</label>
		<select class="form-control">
			<option value="it">Công nghệ thông tin</option>
			<option value="math">Toán học</option>
			<option value="art">Kiến trúc</option>
		</select>
		</div>
		<div class="form-group">
			<label for="year">Năm tuyển sinh:</label>
			<input type="number" class="form-control" name="number" min="2015">
		</div>
		<div class="form-group">
			<label for="forms-of-trainingr">Hình thức đào tạo:</label>
			<select class="form-control">
				<option value="university">Đại học</option>
				<option value="master">Cao học</option>
			</select>
		</div>
		<div class="form-group">
			<label for="trainingr">Cơ sở liên kết đào tạo:</label>
			<select class="form-control">
				<option value="FPT">FPT</option>
				<option value="gosu">Gosu</option>
			</select>
		</div>
		<div class="form-group">
			<label for="date">Ngày thi:</label>
			<input type="text" class="form-control" name="date" >
		</div>
		<div class="form-group">
			<label for="object">Danh sách môn thi:</label>
			<select class="form-control">
				<option value="1">Toán</option>
				<option value="2">Lý</option>
				<option value="3">Hóa</option>
			</select>
		</div>
		
	</form>
	</div><!-- end main-nav -->
</div> <!-- end contentNav -->
</body>
</html>		</div>
		<div class="clear"></div>
		
	<script type="text/javascript">
	$('#menu li').hover(
  		function() {
   		 $('ul', this).stop().slideDown(200);
 		 },
  		function() {
   		 $('ul', this).stop().slideUp(200);
 		 }
	);
	</script>
