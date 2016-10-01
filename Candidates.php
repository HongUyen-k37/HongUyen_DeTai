<!--main content-->
<div class="col-md-9 main-content">
	<div class="candidates_info">
		<div id="form" >
			<h3 style="margin-left:55px;">Thí sinh dự thi</h3>
			<div class="row">
				<div class="col-md-6">
					<form style="width:60%;margin-left:60px;">
						<div class="form-group row">
						<label class="col-md-4" for="first-name">Họ đệm:</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="first-name">
						</div>
						
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="birthday">Ngày sinh</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="birthday">
						</div>
						
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="address">Địa chỉ liên hệ:</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="address">
						</div>
						
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="area">Khu vực:</label>
						<div class="col-md-8 ">
							<select class="form-control" name="area">
								<option value="">Khu vực 1</option>
								<option value="">Khu vực 2</option>
							</select>
						</div>
						
						</div>
					</form>
				</div>
				<div class="col-md-6">
					<form style="width:60%;margin-left:150px;">
						<div class="form-group row">
						<label class="col-md-4" for="last-name">Tên:</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="last-name">
						</div>
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="email">Email</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="email">
						</div>
						
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="phone">Số điện thoại:</label>
						<div class="col-md-8 ">
							<input type="text" class="form-control" name="phone">
						</div>
						
						</div>
						<div class="form-group row">
						<label class="col-md-4" for="Subjects">Đối tượng:</label>
						<div class="col-md-8 ">
							<select class=" form-control" name="Subjects">
								<option value="">Anh hùng lao động</option>
								<option value="">Thương binh liệt sĩ</option>
							</select>
						</div>
						
						</div>
						<div class="btn-group">
							<button type="submit" class="btn btn-success" name='update'>Lưu</button>
							
						</div>
					</form>
				</div>
			</div>
		</div><!-- end form-->
		<div class="details_info">
			<h3 style="margin-left:50px;">Danh sách các thí sinh dự thi</h3>
			<table class="table table-bordered table-hover table-striped"  style="width:90%;">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ đệm</th>
						<th>Tên</th>
						<th>Ngày sinh</th>
						<th>Email</th>
						<th>Khu vực</th>
						<th>Đối tượng</th>
						<th>Số điện thoại</th>
						<th>Địa chỉ liên hệ</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<td>trannunhuquynh260595@gmail.com</td>
						<td>Khu vực 2</td>
						<td></td>
						<td>01648875899</td>
						<td>Quảng Bình</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<td>trannunhuquynh260595@gmail.com</td>
						<td>Khu vực 2</td>
						<td></td>
						<td>01648875899</td>
						<td>Quảng Bình</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<td>trannunhuquynh260595@gmail.com</td>
						<td>Khu vực 2</td>
						<td></td>
						<td>01648875899</td>
						<td>Quảng Bình</td>
					</tr>
					</tbody>
				</table>
				<div class="totalCandidates">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
				</div>
		</div><!-- end details_info -->
	</div> <!-- end candidates_info -->
</div>
<?php
include_once 'contentNav.php';
?>