USE [master]
GO
/****** Object:  Database [QuanLyTuyenSinh]    Script Date: 04/03/2017 1:27:34 PM ******/
CREATE DATABASE [QuanLyTuyenSinh]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyTuyenSinh', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QuanLyTuyenSinh.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyTuyenSinh_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QuanLyTuyenSinh_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyTuyenSinh] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyTuyenSinh].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyTuyenSinh] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyTuyenSinh] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyTuyenSinh]
GO
/****** Object:  StoredProcedure [dbo].[DanhSoBaoDanh]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[DanhSoBaoDanh](@tiepDauNgu nvarchar(10), @soBatDau int, @soLuong int, @maKyThi numeric(18, 0))
as
begin
	declare @maThiSinh numeric(18, 0)
	declare @soBaoDanh nvarchar(50)
	declare contro cursor
	for select maThiSinh from THISINH where maKyThi = @maKyThi
	open contro
	fetch next from contro into @maThiSinh
	while @@FETCH_STATUS = 0
	begin
		set @soBaoDanh = @tiepDauNgu + right('00000000000'+CONVERT([varchar],@soBatDau,(0)),@soLuong)
		print(right('00000000000'+CONVERT([varchar],@soBatDau,(0)),@soLuong));
		update THISINH set soBaoDanh = @soBaoDanh where maThiSinh = @maThiSinh
		set @soBatDau = @soBatDau + 1
		fetch next from contro into @maThiSinh
	end
	close contro
	deallocate contro
end
GO
/****** Object:  Table [dbo].[BAITHI]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAITHI](
	[maKyThi] [numeric](18, 0) NOT NULL,
	[maMonThi] [numeric](18, 0) NOT NULL,
	[maThiSinh] [numeric](18, 0) NOT NULL,
	[soPhach] [int] NULL,
	[tuiSo] [int] NULL,
	[trangThaiDuThi] [int] NULL,
	[diemChamThi] [float] NULL,
	[diemChinhThuc] [float] NULL,
	[ghiChu] [text] NULL,
 CONSTRAINT [PK_BAITHI] PRIMARY KEY CLUSTERED 
(
	[maKyThi] ASC,
	[maMonThi] ASC,
	[maThiSinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KYTHI]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KYTHI](
	[maKyThi] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[tenKyThi] [nvarchar](50) NULL,
	[ngayThi] [nvarchar](50) NULL,
	[namTuyenSinh] [int] NULL,
	[nganh] [nvarchar](50) NULL,
	[hinhThucDT] [nvarchar](50) NULL,
	[coSoLKDT] [nvarchar](50) NULL,
	[soMonThi] [int] NULL,
	[trangThai] [int] NULL,
	[tiepDauNgu] [nvarchar](50) NULL,
	[soBatDau] [int] NULL,
	[soLuongChuSo] [int] NULL,
	[diemChuan] [float] NULL,
	[diemLiet] [float] NULL,
 CONSTRAINT [PK_KYTHI] PRIMARY KEY CLUSTERED 
(
	[maKyThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MONTHI]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MONTHI](
	[maMonThi] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[maKyThi] [numeric](18, 0) NOT NULL,
	[tenMonThi] [nvarchar](50) NULL,
	[trangThaiMonThi] [int] NULL,
	[coSoPhongThi] [int] NULL,
	[coSoTui] [int] NULL,
	[soLuot] [int] NULL,
	[heSo] [int] NULL,
 CONSTRAINT [PK_MONTHI] PRIMARY KEY CLUSTERED 
(
	[maMonThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NGUOIDUNG]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOIDUNG](
	[tenDangNhap] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_NGUOIDUNG] PRIMARY KEY CLUSTERED 
(
	[tenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHONGTHI]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONGTHI](
	[maPhongThi] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[maKyThi] [numeric](18, 0) NOT NULL,
	[soHieuPhongThi] [nvarchar](50) NULL,
	[soLuongThiSinh] [int] NULL,
 CONSTRAINT [PK_PHONGTHI] PRIMARY KEY CLUSTERED 
(
	[maPhongThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[THISINH]    Script Date: 04/03/2017 1:27:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THISINH](
	[maThiSinh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[maKyThi] [numeric](18, 0) NOT NULL,
	[maPhongThi] [numeric](18, 0) NULL,
	[hoDem] [nvarchar](50) NULL,
	[ten] [nvarchar](50) NULL,
	[ngaySinh] [nvarchar](50) NULL,
	[noiSinh] [nvarchar](50) NULL,
	[khuVuc] [nvarchar](50) NULL,
	[doiTuong] [nvarchar](50) NULL,
	[dienThoai] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[diaChi] [text] NULL,
	[soBaoDanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_THISINH] PRIMARY KEY CLUSTERED 
(
	[maThiSinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[KYTHI] ON 

INSERT [dbo].[KYTHI] ([maKyThi], [tenKyThi], [ngayThi], [namTuyenSinh], [nganh], [hinhThucDT], [coSoLKDT], [soMonThi], [trangThai], [tiepDauNgu], [soBatDau], [soLuongChuSo], [diemChuan], [diemLiet]) VALUES (CAST(1 AS Numeric(18, 0)), N'Test', N'02/11', 2017, N'CNTT', N'Đại học', N'FPT', 3, 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KYTHI] ([maKyThi], [tenKyThi], [ngayThi], [namTuyenSinh], [nganh], [hinhThucDT], [coSoLKDT], [soMonThi], [trangThai], [tiepDauNgu], [soBatDau], [soLuongChuSo], [diemChuan], [diemLiet]) VALUES (CAST(2 AS Numeric(18, 0)), N'Tuyển sinh đại học', N'04/08', 2016, N'Toán', N'Đại học', N'Gameloft', 3, 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KYTHI] ([maKyThi], [tenKyThi], [ngayThi], [namTuyenSinh], [nganh], [hinhThucDT], [coSoLKDT], [soMonThi], [trangThai], [tiepDauNgu], [soBatDau], [soLuongChuSo], [diemChuan], [diemLiet]) VALUES (CAST(3 AS Numeric(18, 0)), N'Tuyển sinh cao học', N'04/03', 2017, N'Hóa', N'Cao học', N'Formosa', 3, 1, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KYTHI] OFF
INSERT [dbo].[NGUOIDUNG] ([tenDangNhap], [matKhau]) VALUES (N'admin', N'admin')
INSERT [dbo].[NGUOIDUNG] ([tenDangNhap], [matKhau]) VALUES (N'boy', N'yeubeo')
SET IDENTITY_INSERT [dbo].[THISINH] ON 

INSERT [dbo].[THISINH] ([maThiSinh], [maKyThi], [maPhongThi], [hoDem], [ten], [ngaySinh], [noiSinh], [khuVuc], [doiTuong], [dienThoai], [email], [diaChi], [soBaoDanh]) VALUES (CAST(1 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), NULL, N'Tran Thi Hong', N'Uyen', N'02/11/1995', N'Quang Nam', N'KV1', NULL, N'0969748792', N'honguyen.cnttk37b@gmail.com', N'Que Son', NULL)
INSERT [dbo].[THISINH] ([maThiSinh], [maKyThi], [maPhongThi], [hoDem], [ten], [ngaySinh], [noiSinh], [khuVuc], [doiTuong], [dienThoai], [email], [diaChi], [soBaoDanh]) VALUES (CAST(2 AS Numeric(18, 0)), CAST(2 AS Numeric(18, 0)), NULL, N'Le Chieu', N'Quoc', N'04/08/1995', N'Hue', N'KV2', NULL, N'0978938234', N'quoclee48@gmail.com', N'Hue', N'KHH002')
INSERT [dbo].[THISINH] ([maThiSinh], [maKyThi], [maPhongThi], [hoDem], [ten], [ngaySinh], [noiSinh], [khuVuc], [doiTuong], [dienThoai], [email], [diaChi], [soBaoDanh]) VALUES (CAST(3 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), NULL, N'Thai Trung', N'Duc', N'10/06/1995', N'Quang Binh', N'KV2', NULL, N'01694969244', N'dbom1006@gmail.com', N'Hue', NULL)
SET IDENTITY_INSERT [dbo].[THISINH] OFF
ALTER TABLE [dbo].[BAITHI]  WITH CHECK ADD  CONSTRAINT [FK_BAITHI_KYTHI] FOREIGN KEY([maKyThi])
REFERENCES [dbo].[KYTHI] ([maKyThi])
GO
ALTER TABLE [dbo].[BAITHI] CHECK CONSTRAINT [FK_BAITHI_KYTHI]
GO
ALTER TABLE [dbo].[BAITHI]  WITH CHECK ADD  CONSTRAINT [FK_BAITHI_MONTHI] FOREIGN KEY([maMonThi])
REFERENCES [dbo].[MONTHI] ([maMonThi])
GO
ALTER TABLE [dbo].[BAITHI] CHECK CONSTRAINT [FK_BAITHI_MONTHI]
GO
ALTER TABLE [dbo].[BAITHI]  WITH CHECK ADD  CONSTRAINT [FK_BAITHI_THISINH] FOREIGN KEY([maThiSinh])
REFERENCES [dbo].[THISINH] ([maThiSinh])
GO
ALTER TABLE [dbo].[BAITHI] CHECK CONSTRAINT [FK_BAITHI_THISINH]
GO
ALTER TABLE [dbo].[MONTHI]  WITH CHECK ADD  CONSTRAINT [FK_MONTHI_KYTHI] FOREIGN KEY([maKyThi])
REFERENCES [dbo].[KYTHI] ([maKyThi])
GO
ALTER TABLE [dbo].[MONTHI] CHECK CONSTRAINT [FK_MONTHI_KYTHI]
GO
ALTER TABLE [dbo].[PHONGTHI]  WITH CHECK ADD  CONSTRAINT [FK_PHONGTHI_KYTHI] FOREIGN KEY([maKyThi])
REFERENCES [dbo].[KYTHI] ([maKyThi])
GO
ALTER TABLE [dbo].[PHONGTHI] CHECK CONSTRAINT [FK_PHONGTHI_KYTHI]
GO
ALTER TABLE [dbo].[THISINH]  WITH CHECK ADD  CONSTRAINT [FK_THISINH_KYTHI] FOREIGN KEY([maKyThi])
REFERENCES [dbo].[KYTHI] ([maKyThi])
GO
ALTER TABLE [dbo].[THISINH] CHECK CONSTRAINT [FK_THISINH_KYTHI]
GO
ALTER TABLE [dbo].[THISINH]  WITH CHECK ADD  CONSTRAINT [FK_THISINH_PHONGTHI] FOREIGN KEY([maPhongThi])
REFERENCES [dbo].[PHONGTHI] ([maPhongThi])
GO
ALTER TABLE [dbo].[THISINH] CHECK CONSTRAINT [FK_THISINH_PHONGTHI]
GO
USE [master]
GO
ALTER DATABASE [QuanLyTuyenSinh] SET  READ_WRITE 
GO
