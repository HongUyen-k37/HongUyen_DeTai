<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<?php
					include_once 'thongtin-side.php'; 
				?>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav" >
				<p class="title">THÔNG TIN THÍ SINH DỰ THI</p>
				<form action="" class="form-horizontal" method="POST" role="form">
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-2 no-pad" for="first-name">Họ đệm:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="first-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="birthday-place">Nơi sinh:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="birthday-place">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="Subjects">Đối tượng:</label>
							<div class="col-md-10">
								<select class=" form-control" name="Subjects">
									<option value="">Anh hùng lao động</option>
									<option value="">Thương binh liệt sĩ</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="email">Email:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="email">
							</div>
						</div>
					</div>
					<div class="col-md-5 pad-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="last-name">Tên:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="last-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="birthday">Ngày sinh:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="birthday">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="area">Khu vực:</label>
							<div class="col-md-8 ">
								<select class="form-control" name="area">
									<option value="">Khu vực 1</option>
									<option value="">Khu vực 2</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="phone">Số điện thoại:</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="phone">
							</div>
						</div>
					</div>
				</form>
			</div><!-- end form-->
		<div class="main-nav">
			<label for="address">Địa chỉ liên hệ:</label>
			<textarea class="form-control" rows="4" cols="100" name="address"></textarea>
		</div>
		<div class="btn-gr">
			<button type="submit" class="btn btn-success btn-all" name='add'>Thêm</button>
			<button type="submit" class="btn btn-success btn-all" name='update'>Lưu</button>
			<button type="submit" class="btn btn-success btn-all" name='delete'>Xoá</button>
		</div>
		<div class="details_info">
			<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ đệm</th>
						<th>Tên</th>
						<th>Ngày sinh</th>
						<!-- <th>Email</th> -->
						<th>Khu vực</th>
						<th>Đối tượng</th>
						<!-- <th>Số điện thoại</th>
						<th>Địa chỉ liên hệ</th> -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<!-- <td>trannunhuquynh260595@gmail.com</td> -->
						<td>Khu vực 2</td>
						<td></td>
						<!-- <td>01648875899</td>
						<td>Quảng Bình</td> -->
					</tr>
					<tr>
						<td>2</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<!-- <td>trannunhuquynh260595@gmail.com</td> -->
						<td>Khu vực 2</td>
						<td>Anh hùng lao động</td>
						<!-- <td>01648875899</td>
						<td>Quảng Bình</td> -->
					</tr>
					<tr>
						<td>3</td>
						<td>Trần Nữ Như</td>
						<td>Quỳnh</td>
						<td>26/05/1995</td>
						<!-- <td>trannunhuquynh260595@gmail.com</td> -->
						<td>Khu vực 2</td>
						<td></td>
						<!-- <td>01648875899</td>
						<td>Quảng Bình</td> -->
					</tr>
					</tbody>
				</table>
				<div class="totalCandidates">
					<p>Danh sách gồm có: <span> 50/100 </span> sinh viên</p>
				</div>
		</div><!-- end details_info -->
		</div>
		</div>
	</div>
</div>