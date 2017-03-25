USE [master]
GO
/****** Object:  Database [DeTaiBeo]    Script Date: 03/26/2017 12:19:39 AM ******/
CREATE DATABASE [DeTaiBeo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DeTaiBeo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\DeTaiBeo.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DeTaiBeo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\DeTaiBeo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DeTaiBeo] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DeTaiBeo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DeTaiBeo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DeTaiBeo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DeTaiBeo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DeTaiBeo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DeTaiBeo] SET ARITHABORT OFF 
GO
ALTER DATABASE [DeTaiBeo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DeTaiBeo] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [DeTaiBeo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DeTaiBeo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DeTaiBeo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DeTaiBeo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DeTaiBeo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DeTaiBeo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DeTaiBeo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DeTaiBeo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DeTaiBeo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DeTaiBeo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DeTaiBeo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DeTaiBeo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DeTaiBeo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DeTaiBeo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DeTaiBeo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DeTaiBeo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DeTaiBeo] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DeTaiBeo] SET  MULTI_USER 
GO
ALTER DATABASE [DeTaiBeo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DeTaiBeo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DeTaiBeo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DeTaiBeo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [DeTaiBeo]
GO
/****** Object:  Table [dbo].[BAITHI]    Script Date: 03/26/2017 12:19:39 AM ******/
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
/****** Object:  Table [dbo].[KYTHI]    Script Date: 03/26/2017 12:19:39 AM ******/
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
	[coSoPhongThi] [int] NULL,
	[soLuot] [int] NULL,
	[tiepDauNgu] [nvarchar](50) NULL,
	[soBatDau] [int] NULL,
	[coSoTui] [int] NULL,
	[soLuongChuSo] [int] NULL,
	[diemChuan] [float] NULL,
	[diemLiet] [float] NULL,
 CONSTRAINT [PK_KYTHI] PRIMARY KEY CLUSTERED 
(
	[maKyThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MONTHI]    Script Date: 03/26/2017 12:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MONTHI](
	[maMonThi] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[maKyThi] [numeric](18, 0) NOT NULL,
	[tenMonThi] [nvarchar](50) NULL,
	[trangThaiMonThi] [int] NULL,
 CONSTRAINT [PK_MONTHI] PRIMARY KEY CLUSTERED 
(
	[maMonThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NGUOIDUNG]    Script Date: 03/26/2017 12:19:39 AM ******/
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
/****** Object:  Table [dbo].[PHONGTHI]    Script Date: 03/26/2017 12:19:39 AM ******/
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
/****** Object:  Table [dbo].[THISINH]    Script Date: 03/26/2017 12:19:39 AM ******/
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

INSERT [dbo].[KYTHI] ([maKyThi], [tenKyThi], [ngayThi], [namTuyenSinh], [nganh], [hinhThucDT], [coSoLKDT], [soMonThi], [trangThai], [coSoPhongThi], [soLuot], [tiepDauNgu], [soBatDau], [coSoTui], [soLuongChuSo], [diemChuan], [diemLiet]) VALUES (CAST(1 AS Numeric(18, 0)), N'Test', N'02/11', 2017, N'CNTT', N'Đại học', N'FPT', 3, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KYTHI] ([maKyThi], [tenKyThi], [ngayThi], [namTuyenSinh], [nganh], [hinhThucDT], [coSoLKDT], [soMonThi], [trangThai], [coSoPhongThi], [soLuot], [tiepDauNgu], [soBatDau], [coSoTui], [soLuongChuSo], [diemChuan], [diemLiet]) VALUES (CAST(2 AS Numeric(18, 0)), N'Tuyển sinh đại học', N'04/08', 2016, N'Toán', N'Cao học', N'Gameloft', 3, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KYTHI] OFF
INSERT [dbo].[NGUOIDUNG] ([tenDangNhap], [matKhau]) VALUES (N'admin', N'admin')
INSERT [dbo].[NGUOIDUNG] ([tenDangNhap], [matKhau]) VALUES (N'boy', N'yeubeo')
SET IDENTITY_INSERT [dbo].[THISINH] ON 

INSERT [dbo].[THISINH] ([maThiSinh], [maKyThi], [maPhongThi], [hoDem], [ten], [ngaySinh], [noiSinh], [khuVuc], [doiTuong], [dienThoai], [email], [diaChi], [soBaoDanh]) VALUES (CAST(1 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), NULL, N'Tran Thi Hong', N'Uyen', N'02/11/1995', N'Quang Nam', N'KV1', NULL, N'0969748792', N'honguyen.cnttk37b@gmail.com', N'Que Son', NULL)
INSERT [dbo].[THISINH] ([maThiSinh], [maKyThi], [maPhongThi], [hoDem], [ten], [ngaySinh], [noiSinh], [khuVuc], [doiTuong], [dienThoai], [email], [diaChi], [soBaoDanh]) VALUES (CAST(2 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), NULL, N'Le Chieu', N'Quoc', N'04/08/1995', N'Hue', N'KV2', NULL, N'0978938234', N'quoclee48@gmail.com', N'Hue', NULL)
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
ALTER DATABASE [DeTaiBeo] SET  READ_WRITE 
GO
