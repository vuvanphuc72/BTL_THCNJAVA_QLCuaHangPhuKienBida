-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 30, 2025 lúc 10:08 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bidastore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaChiTietHoaDon` int(11) NOT NULL,
  `MaHoaDon` int(11) DEFAULT NULL,
  `MaSanPham` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `GiaTaiThoiDiem` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaChiTietHoaDon`, `MaHoaDon`, `MaSanPham`, `SoLuong`, `GiaTaiThoiDiem`) VALUES
(2, 1, 4, 1, 80000.00),
(4, 2, 3, 2, 150000.00),
(5, 3, 3, 1, 150000.00),
(6, 3, 16, 1, 65000.00),
(7, 4, 5, 1, 25000000.00),
(11, 7, 9, 1, 300000.00),
(26, 21, 9, 1, 300000.00),
(27, 21, 6, 3, 270000.00),
(28, 21, 8, 2, 1700000.00),
(29, 21, 10, 2, 900000.00),
(30, 32, 6, 1, 90000.00),
(36, 38, 8, 2, 1700000.00),
(37, 38, 12, 2, 340000.00),
(38, 38, 4, 3, 240000.00),
(39, 38, 14, 1, 50000.00),
(40, 39, 8, 2, 1700000.00),
(41, 39, 12, 2, 340000.00),
(42, 39, 4, 3, 240000.00),
(43, 39, 14, 1, 50000.00),
(44, 40, 8, 3, 2550000.00),
(45, 40, 9, 2, 600000.00),
(46, 40, 5, 1, 25000000.00),
(47, 41, 8, 1, 850000.00),
(48, 41, 10, 3, 1350000.00),
(49, 42, 7, 2, 360000.00),
(50, 42, 10, 2, 900000.00),
(51, 42, 5, 3, 75000000.00),
(52, 42, 9, 2, 600000.00),
(53, 43, 7, 2, 360000.00),
(54, 43, 10, 2, 900000.00),
(55, 43, 5, 3, 75000000.00),
(56, 43, 9, 2, 600000.00),
(57, 43, 13, 2, 80000.00),
(58, 44, 7, 2, 360000.00),
(59, 44, 10, 2, 900000.00),
(60, 44, 9, 2, 600000.00),
(61, 44, 13, 2, 80000.00),
(62, 44, 9, 4, 1200000.00),
(63, 44, 5, 2, 50000000.00),
(65, 66, 5, 0, 0.00),
(66, 67, 5, 1, 25000000.00),
(67, 68, 8, 2, 1700000.00),
(68, 68, 12, 3, 510000.00),
(69, 68, 9, 1, 300000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `MaKhachHang` int(11) DEFAULT NULL,
  `MaNhanVien` int(11) DEFAULT NULL,
  `NgayDatHang` date DEFAULT NULL,
  `TongTien` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaKhachHang`, `MaNhanVien`, `NgayDatHang`, `TongTien`) VALUES
(1, 1, 1, '2024-05-01', 1300000.00),
(2, 2, 2, '2024-05-02', 2500000.00),
(3, 3, 3, '2024-05-03', 1200000.00),
(4, 4, 4, '2024-05-04', 800000.00),
(7, 7, 7, '2024-05-07', 2000000.00),
(21, 12, 1, '2025-05-25', 3170000.00),
(32, 1, 1, '2025-05-25', 90000.00),
(38, 9, 1, '2025-05-27', 2330000.00),
(39, 9, 1, '2025-05-27', 2330000.00),
(40, 12, 2, '2025-05-28', 28150000.00),
(41, 1, 3, '2025-05-28', 2200000.00),
(42, 9, 2, '2025-05-28', 76860000.00),
(43, 9, 2, '2025-05-28', 76940000.00),
(44, 6, 3, '2025-05-28', 53140000.00),
(45, 3, 1, '2023-01-10', 950000.00),
(46, 5, 2, '2023-02-15', 1200000.00),
(47, 7, 3, '2023-03-20', 450000.00),
(48, 2, 4, '2023-04-25', 780000.00),
(49, 1, 1, '2023-05-30', 1030000.00),
(50, 4, 2, '2023-06-18', 590000.00),
(51, 6, 3, '2023-07-12', 870000.00),
(52, 8, 4, '2023-08-28', 1330000.00),
(53, 10, 1, '2023-09-14', 720000.00),
(54, 9, 2, '2023-10-05', 680000.00),
(55, 12, 3, '2023-11-19', 1100000.00),
(56, 11, 4, '2023-12-02', 495000.00),
(57, 13, 1, '2024-01-08', 910000.00),
(58, 14, 2, '2024-02-17', 1230000.00),
(59, 15, 3, '2024-03-25', 660000.00),
(60, 3, 4, '2024-04-06', 540000.00),
(61, 5, 1, '2024-05-15', 990000.00),
(62, 7, 2, '2024-06-23', 870000.00),
(63, 6, 3, '2024-07-31', 1340000.00),
(64, 2, 4, '2024-08-22', 750000.00),
(66, 12, 4, '2025-05-28', 0.00),
(67, 12, 4, '2025-05-28', 25000000.00),
(68, 6, 1, '2025-05-28', 2510000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `HoTen` varchar(100) DEFAULT NULL,
  `SoDienThoai` varchar(15) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `HoTen`, `SoDienThoai`, `Email`, `DiaChi`) VALUES
(1, 'Nguyễn Văn Hiếu', '0900000001', 'a@gmail.com', 'Hà Nội'),
(2, 'Trần Thị Bưởi', '0900000002', 'b@gmail.com', 'Hồ Chí Minh'),
(3, 'Lê Văn Cầu', '0900000003', 'c@gmail.com', 'Đà Nẵng'),
(4, 'Phạm Thị D', '0900000004', 'd@gmail.com', 'Hải Phòng'),
(5, 'Hoàng Văn E', '0900000005', 'e@gmail.com', 'Cần Thơ'),
(6, 'Ngô Thị F', '0900000006', 'f@gmail.com', 'Bình Dương'),
(7, 'Đỗ Văn G', '0900000007', 'g@gmail.com', 'Nghệ An'),
(8, 'Vũ Thị H', '0900000008', 'h@gmail.com', 'Huế'),
(9, 'Bùi Văn I', '0900000009', 'i@gmail.com', 'Lâm Đồng'),
(10, 'Đinh Thị J', '0900000010', 'j@gmail.com', 'Quảng Ninh'),
(11, 'Phan Văn K', '0900000011', 'k@gmail.com', 'Hà Tĩnh'),
(12, 'Hà Thị L', '0900000012', 'l@gmail.com', 'Hậu Giang'),
(13, 'Tạ Văn M', '0900000013', 'm@gmail.com', 'Ninh Bình'),
(14, 'Cao Thị N', '0900000014', 'n@gmail.com', 'Bắc Ninh'),
(15, 'Châu Văn O', '0900000015', 'o@gmail.com', 'Phú Yên'),
(16, 'Lâm Thị P', '0900000016', 'p@gmail.com', 'Bình Phước'),
(17, 'Trịnh Văn Q', '0900000017', 'q@gmail.com', 'Bắc Giang'),
(23, 'Ngô Bá Khá', '099999999', 'e@gmail.com', 'Cần Thơ'),
(24, 'Nguyễn Văn Anh', '0901234567', 'anhnguyen@gmail.com', 'Hà Nội'),
(25, 'Trần Thị Bình', '0912345678', 'binhtran@gmail.com', 'TP.HCM'),
(26, 'Lê Văn Châu', '0923456789', 'chaule@gmail.com', 'Đà Nẵng'),
(27, 'Phạm Thị Dung', '0934567890', 'dungpham@gmail.com', 'Cần Thơ'),
(28, 'Hoàng Văn Duy', '0945678901', 'duyhoang@gmail.com', 'Hải Phòng'),
(29, 'Đỗ Thị Hoa', '0956789012', 'hoado@gmail.com', 'Nha Trang'),
(30, 'Ngô Văn Giang', '0967890123', 'giangngo@gmail.com', 'Bình Dương'),
(31, 'Vũ Thị Hạnh', '0978901234', 'hanhvut@gmail.com', 'Huế'),
(32, 'Bùi Văn Hùng', '0989012345', 'hungbui@gmail.com', 'Quảng Ninh'),
(33, 'Đặng Thị Khánh', '0990123456', 'khanhdang@gmail.com', 'Vũng Tàu'),
(34, 'Phan Văn Long', '0901111222', 'longphan@gmail.com', 'Hà Nam'),
(35, 'Tô Thị Mai', '0912222333', 'maito@gmail.com', 'Nam Định'),
(36, 'Lý Văn Nam', '0923333444', 'namly@gmail.com', 'Bắc Giang'),
(37, 'Cao Thị Oanh', '0934444555', 'oanhcao@gmail.com', 'Thanh Hóa'),
(38, 'Trịnh Văn Phúc', '0945555666', 'phuctrinh@gmail.com', 'Ninh Bình'),
(39, 'Hồ Thị Quỳnh', '0956666777', 'quynhho@gmail.com', 'Phú Thọ'),
(40, 'Kiều Văn Quốc', '0967777888', 'quoctkieu@gmail.com', 'Thái Bình'),
(41, 'Đinh Thị Sang', '0978888999', 'sangdinh@gmail.com', 'Bắc Ninh'),
(42, 'La Văn Tùng', '0989999000', 'tungla@gmail.com', 'Lào Cai'),
(43, 'Dương Thị Uyên', '0990000111', 'uyenduong@gmail.com', 'Yên Bái'),
(44, 'Nguyễn Thị Ánh', '0902222333', 'anhnguyen2@gmail.com', 'Hải Dương'),
(45, 'Trần Văn Bảo', '0913333444', 'baotran@gmail.com', 'Bình Định'),
(46, 'Lê Thị Cẩm', '0924444555', 'camle@gmail.com', 'Hà Tĩnh'),
(47, 'Phạm Văn Dương', '0935555666', 'duongpham@gmail.com', 'Lâm Đồng'),
(48, 'Hoàng Thị Diễm', '0946666777', 'diemhoang@gmail.com', 'Tây Ninh'),
(49, 'Đỗ Văn Hòa', '0957777888', 'hoado2@gmail.com', 'Tiền Giang'),
(50, 'Ngô Thị Huệ', '0968888999', 'huengo@gmail.com', 'Sóc Trăng'),
(51, 'Vũ Văn Hưng', '0979999000', 'hungvu@gmail.com', 'An Giang'),
(52, 'Bùi Thị Khuê', '0980000111', 'khuebui@gmail.com', 'Bình Phước'),
(53, 'Đặng Văn Linh', '0991111222', 'linhdang@gmail.com', 'Bạc Liêu'),
(54, 'Phan Thị Lệ', '0902222111', 'lephan@gmail.com', 'Long An'),
(55, 'Tô Văn Mạnh', '0913333222', 'manhto@gmail.com', 'Gia Lai'),
(56, 'Lý Thị Ngọc', '0924444333', 'ngocly@gmail.com', 'Bến Tre'),
(57, 'Cao Văn Nhật', '0935555444', 'nhatcao@gmail.com', 'Kon Tum'),
(58, 'Trịnh Thị Phương', '0946666555', 'phuongtrinh@gmail.com', 'Vĩnh Long'),
(59, 'Hồ Văn Quang', '0957777666', 'quangho@gmail.com', 'Trà Vinh'),
(60, 'Kiều Thị Sen', '0968888777', 'senkieu@gmail.com', 'Đắk Lắk'),
(61, 'Đinh Văn Thiện', '0979999888', 'thiendinh@gmail.com', 'Đắk Nông'),
(62, 'La Thị Thúy', '0980000999', 'thuylala@gmail.com', 'Hậu Giang'),
(63, 'Dương Văn Việt', '0991111999', 'vietduong@gmail.com', 'Ninh Thuận'),
(65, 'Trần Văn Trung', '0393768295', 'tvt@gmail.com', 'Nghệ An');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLoaiSanPham` int(11) NOT NULL,
  `TenLoaiSanPham` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoaiSanPham`, `TenLoaiSanPham`) VALUES
(3, 'Bao tay'),
(4, 'Phấn đánh cơ'),
(5, 'Bàn bida'),
(6, 'Lưới bi'),
(7, 'Găng tay'),
(8, 'Ghế ngồi'),
(9, 'Túi đựng cơ'),
(10, 'Giá để cơ'),
(12, 'Găng tay chuyên dụng'),
(13, 'Khăn lau cơ'),
(14, 'Đầu cơ'),
(15, 'Phụ kiện bàn'),
(16, 'Gôm đánh bi'),
(17, 'Đèn bàn bida'),
(18, 'Thảm trải bàn'),
(20, 'Phụ kiện khác'),
(25, 'Gậy phá bi'),
(26, 'Cơ bida'),
(28, 'Găng'),
(29, 'Bàn bida'),
(30, 'Lơ bi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` int(11) NOT NULL,
  `HoTen` varchar(100) DEFAULT NULL,
  `SoDienThoai` varchar(15) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `NgayTuyenDung` date DEFAULT NULL,
  `MatKhau` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTen`, `SoDienThoai`, `Email`, `NgayTuyenDung`, `MatKhau`) VALUES
(1, 'Vũ Văn Phúc', '0393068295', 'vvp@gmail.com', '2025-02-07', '3737'),
(2, 'Kiều Đình Tuấn', '0357806547', 'kdt@gmail.com', '2023-02-01', '123456'),
(3, 'Trần Văn Trung', '0357229700', 'tvt@gmail.com', '2023-03-01', '123456'),
(4, 'Nguyễn Long Vũ', '0358962845', 'nlv@gmail.com', '2023-04-01', '123'),
(7, 'Đỗ Nhân Đạo', '0911000007', 'nv_g@gmail.com', '2023-07-01', '123456'),
(22, '1', '1', '1', '2025-02-07', '1'),
(26, 'Nguyễn Thị Lan', '0901010101', 'lannguyen@company.com', '2022-01-15', 'mk123456'),
(27, 'Trần Văn Hòa', '0912020202', 'hoatran@company.com', '2021-05-20', 'mk234567'),
(28, 'Lê Thị Hương', '0923030303', 'huongle@company.com', '2023-03-10', 'mk345678'),
(29, 'Phạm Văn Khánh', '0934040404', 'khanhpham@company.com', '2020-11-01', 'mk456789'),
(30, 'Hoàng Thị Như', '0945050505', 'nhuhoang@company.com', '2019-08-25', 'mk567890'),
(31, 'Đỗ Văn Thịnh', '0956060606', 'thinhdo@company.com', '2024-02-12', 'mk678901'),
(32, 'Ngô Thị Thu', '0967070707', 'thungo@company.com', '2022-07-07', 'mk789012'),
(33, 'Vũ Văn Thành', '0978080808', 'thanhvu@company.com', '2021-04-18', 'mk890123'),
(34, 'Bùi Thị Yến', '0989090909', 'yenbui@company.com', '2020-12-30', 'mk901234'),
(35, 'Đặng Văn Hải', '0990000001', 'haidang@company.com', '2018-10-10', 'mk012345'),
(36, 'Phan Thị Hằng', '0901111222', 'hangphan@company.com', '2023-05-05', 'mk112233'),
(37, 'Tô Văn Minh', '0912222333', 'minhto@company.com', '2019-09-09', 'mk223344'),
(38, 'Lý Thị Thảo', '0923333444', 'thaoly@company.com', '2022-12-01', 'mk334455'),
(39, 'Cao Văn Kiên', '0934444555', 'kiencao@company.com', '2020-01-22', 'mk445566'),
(40, 'Trịnh Thị Mỹ', '0945555666', 'mytrinh@company.com', '2024-03-18', 'mk556677'),
(41, 'Hồ Văn Toàn', '0956666777', 'toanho@company.com', '2021-06-06', 'mk667788'),
(42, 'Kiều Thị Mai', '0967777888', 'maikieu@company.com', '2022-08-20', 'mk778899'),
(43, 'Đinh Văn Phúc', '0978888999', 'phucdinh@company.com', '2020-04-14', 'mk889900'),
(44, 'La Thị Vân', '0989999000', 'vanla@company.com', '2023-07-21', 'mk990011'),
(45, 'Dương Văn Tài', '0990000111', 'taiduong@company.com', '2019-02-02', 'mk001122');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(11) NOT NULL,
  `TenSanPham` varchar(100) DEFAULT NULL,
  `GiaDonVi` decimal(10,2) DEFAULT NULL,
  `SoLuongTon` int(11) DEFAULT NULL,
  `MaLoaiSanPham` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `GiaDonVi`, `SoLuongTon`, `MaLoaiSanPham`) VALUES
(3, 'Bao tay Hàn Quốc', 150000.00, 50, 3),
(4, 'Phấn Kamui', 80000.00, 30, 4),
(5, 'Bàn Hollywood', 25000000.00, 2, 5),
(6, 'Lưới bi da bò', 90000.00, 40, 6),
(7, 'Găng tay Predator', 180000.00, 20, 7),
(8, 'Ghế bida sang trọng', 850000.00, 5, 8),
(9, 'Túi cơ 2x2', 300000.00, 12, 9),
(10, 'Giá để cơ gỗ sồi', 450000.00, 6, 10),
(12, 'Găng tay Phoenix', 170000.00, 15, 12),
(13, 'Khăn lau lông mềm', 40000.00, 60, 13),
(14, 'Đầu cơ Predator', 50000.00, 80, 14),
(15, 'Phụ kiện bàn bi', 150000.00, 10, 15),
(16, 'Gôm Nhật Bản', 65000.00, 20, 16),
(17, 'Đèn bàn chuyên dụng', 3000000.00, 3, 17),
(18, 'Thảm trải cao su non', 1200000.00, 4, 18),
(21, 'Bao tay Nhật Bản chính hãng', 150000.00, 999, 3),
(27, 'Cơ rồng bạc', 100000.00, 999, 26),
(28, 'Cơ rồng xanh', 1300000.00, 999, 26),
(29, 'Cơ rồng xanh blue', 1250000.00, 999, 26),
(33, 'Bàn vip pro', 20000000.00, 999, 29);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaChiTietHoaDon`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaSanPham` (`MaSanPham`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaKhachHang` (`MaKhachHang`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLoaiSanPham`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `MaLoaiSanPham` (`MaLoaiSanPham`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  MODIFY `MaChiTietHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoaiSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNhanVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`) ON DELETE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoaiSanPham`) REFERENCES `loaisanpham` (`MaLoaiSanPham`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
