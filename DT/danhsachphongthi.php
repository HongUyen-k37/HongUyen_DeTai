<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<?php
					include_once 'thongtin-side.php'; 
				?>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">PHÒNG THI</p>
				<form>
					<div class="form-group row">
						<label class="col-md-2" for="sl">Danh sách:</label>
						<div class="col-md-10">
							<select class="form-control">
								<option value="xtc">Xem tất cả</option>
								<option value="01">Phòng số 01</option>
								<option value="02">Phòng số 02</option>
								<option value="03">Phòng số 03</option>
							</select>
						</div>
					</div>
				</form>
				</div>
				<div role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a href="#dsPhongThi" aria-controls="home" role="tab" data-toggle="tab">Danh sách phòng thi</a>
						</li>
						<li role="presentation">
							<a href="#bienbanPhongThi" aria-controls="tab" role="tab" data-toggle="tab">Biên bản phòng thi</a>
						</li>
						<li class="export-excel">
							<a href="javascript:download()" >Tải xuống</a>
						</li>
						<script type="text/javascript">
							function download(){
								var id=1;
								if($("#bienbanPhongThi").hasClass("active")) id=2;
								//Gửi dữ liệu lên server để tải = Ajax
							}
						</script>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="dsPhongThi">
							<?php	
							include_once 'tab1.php';
							?>	
						</div>
						<div role="tabpanel" class="tab-pane fade" id="bienbanPhongThi">
							<?php	
							include_once 'tab2.php';
							?>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>