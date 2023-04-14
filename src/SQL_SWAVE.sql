CREATE DATABASE SWAVE
GO
USE SWAVE
GO


-- CREATE TABLES
CREATE TABLE TAIKHOAN (
	TenTK VARCHAR(20) NOT NULL,
	MatKhau	VARCHAR(20),
	VaiTro BIT DEFAULT 0,
	TrangThai BIT DEFAULT 1
)

GO
CREATE TABLE NGUOIDUNG (
	MaND INT IDENTITY NOT NULL, 
	HoTen NVARCHAR(50),
	NgaySinh DATE DEFAULT GETDATE(),
	GioiTinh BIT, -- Nam là 1 nữ là 0
	Email VARCHAR(30),
	Avatar VARCHAR(100),
	TenTK VARCHAR(20)
)

GO
CREATE TABLE BAIHAT (
	MaBH INT IDENTITY NOT NULL,
	TenBH NVARCHAR(100),
	NhacSi NVARCHAR(100),
	CaSi NVARCHAR(100),
	TheLoai NVARCHAR(100),
	LoiBH VARCHAR(100),
	HinhAnh VARCHAR(100),
	FileBH VARCHAR(100),
	TrangThai BIT DEFAULT 0,
	NgayDang DATE DEFAULT GETDATE(),
	MaND INT
)

GO
CREATE TABLE PLAYLIST (
	MaPlayList INT IDENTITY NOT NULL,
	TenPlayList NVARCHAR(100),
	RiengTu BIT DEFAULT 1,
	HinhAnh NVARCHAR(100),
	MaND INT
)
GO
CREATE TABLE BAIHATPLAYLIST (
	STT INT IDENTITY NOT NULL,
	MaPlayList INT NOT NULL,
	MaBH INT NOT NULL
)

GO
CREATE TABLE BAIHATYEUTHICH (
	STT INT IDENTITY NOT NULL,
	MaBH INT NOT NULL,
	MaND INT NOT NULL
)
GO

CREATE TABLE LUOTNGHE (
	STT	INT IDENTITY NOT NULL,
	MaBH INT NOT NULL,
	MaND INT NOT NULL,
	Time DATETIME DEFAULT GETDATE()
)

GO
CREATE TABLE LUOTYEUTHICH (
	MaBH INT NOT NULL,
	MaND INT NOT NULL,
	Time DATETIME DEFAULT GETDATE()
)

GO
CREATE TABLE LUOTYEUTHICHPLAYLIST (
	MaPlayList INT NOT NULL,
	MaND INT NOT NULL,
	Time DATETIME DEFAULT GETDATE()
)
GO
CREATE TABLE BINHLUAN (
	MaBL INT IDENTITY NOT NULL,
	STT INT,
	NoiDung NVARCHAR(200),
	NgayTao DATETIME DEFAULT GETDATE(),
	MaBH INT,
	MaND INT
)
GO
CREATE TABLE TUONGTACBINHLUAN (
	MaBL INT NOT NULL,
	MaND INT NOT NULL,
	TrangThai BIT
)
GO
CREATE TABLE BAOCAOBINHLUAN (
	MaBL INT NOT NULL,
	MaND INT NOT NULL
)
GO

-------------------------------------------
GO
ALTER TABLE TAIKHOAN ADD CONSTRAINT PK_TAIKHOAN PRIMARY KEY (TenTK)
ALTER TABLE NGUOIDUNG ADD CONSTRAINT PK_NGUOIDUNG PRIMARY KEY (MaND)
ALTER TABLE BAIHAT ADD CONSTRAINT PK_BAIHAT PRIMARY KEY (MaBH)
ALTER TABLE PLAYLIST ADD CONSTRAINT PK_PLAYLIST PRIMARY KEY (MaPlayList)
ALTER TABLE BAIHATPLAYLIST ADD CONSTRAINT PK_BAIHATPLAYLIST PRIMARY KEY (STT, MaPlayList, MaBH)
ALTER TABLE BAIHATYEUTHICH ADD CONSTRAINT PK_BAIHATYEUTHICH PRIMARY KEY (STT, MaBH, MaND)
ALTER TABLE LUOTNGHE ADD CONSTRAINT PK_LUOTNGHE PRIMARY KEY (STT, MaBH, MaND)
ALTER TABLE LUOTYEUTHICH ADD CONSTRAINT PK_LUOTYEUTHICH PRIMARY KEY (MaBH, MaND)
ALTER TABLE LUOTYEUTHICHPLAYLIST ADD CONSTRAINT PK_LUOTYEUTHICHPLAYLIST PRIMARY KEY (MaPlayList, MaND)
ALTER TABLE BINHLUAN ADD CONSTRAINT PK_BINHLUAN PRIMARY KEY (MaBL)
ALTER TABLE TUONGTACBINHLUAN ADD CONSTRAINT PK_TUONGTACBINHLUAN PRIMARY KEY (MaBL, MaND)
ALTER TABLE BAOCAOBINHLUAN ADD CONSTRAINT PK_BAOCAOBINHLUAN PRIMARY KEY (MaBL, MaND)


-------------------------------------------
GO
ALTER TABLE NGUOIDUNG ADD CONSTRAINT FK_NGUOIDUNG_TAIKHOAN FOREIGN KEY (TenTK) REFERENCES TAIKHOAN(TenTK) ON DELETE CASCADE
ALTER TABLE BAIHAT ADD CONSTRAINT FK_BAIHAT_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND) ON DELETE CASCADE
ALTER TABLE BAIHATPLAYLIST ADD CONSTRAINT FK_BAIHATPLAYLIST_PLAYLIST FOREIGN KEY (MaPlayList) REFERENCES PLAYLIST(MaPlayList) ON DELETE CASCADE
ALTER TABLE BAIHATPLAYLIST ADD CONSTRAINT FK_BAIHATPLAYLIST_BAIHAT FOREIGN KEY (MaBH) REFERENCES BAIHAT(MaBH) ON DELETE CASCADE
ALTER TABLE BAIHATYEUTHICH ADD CONSTRAINT FK_BAIHATYEUTHICH_BAIHAT FOREIGN KEY (MaBH) REFERENCES BAIHAT(MaBH) ON DELETE CASCADE
ALTER TABLE BAIHATYEUTHICH ADD CONSTRAINT FK_BAIHATYEUTHICH_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND)
ALTER TABLE LUOTNGHE ADD CONSTRAINT FK_LUOTNGHE_BAIHAT FOREIGN KEY (MaBH) REFERENCES BAIHAT(MaBH) ON DELETE CASCADE
ALTER TABLE LUOTNGHE ADD CONSTRAINT FK_LUOTNGHE_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND)
ALTER TABLE LUOTYEUTHICH ADD CONSTRAINT FK_LUOTYEUTHICH_BAIHAT FOREIGN KEY (MaBH) REFERENCES BAIHAT(MaBH) ON DELETE CASCADE
ALTER TABLE LUOTYEUTHICH ADD CONSTRAINT FK_LUOTYEUTHICH_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND)
ALTER TABLE LUOTYEUTHICHPLAYLIST ADD CONSTRAINT FK_LUOTYEUTHICHPLAYLIST_PLAYLIST FOREIGN KEY (MaPlayList) REFERENCES PLAYLIST(MaPlayList) ON DELETE CASCADE
ALTER TABLE LUOTYEUTHICHPLAYLIST ADD CONSTRAINT FK_LUOTYEUTHICHPLAYLIST_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND) ON DELETE CASCADE
ALTER TABLE BINHLUAN ADD CONSTRAINT FK_BINHLUAN_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND) ON DELETE CASCADE
ALTER TABLE TUONGTACBINHLUAN ADD CONSTRAINT FK_TUONGTACBINHLUAN_BINHLUAN FOREIGN KEY (MaBL) REFERENCES BINHLUAN(MaBL) ON DELETE CASCADE
ALTER TABLE TUONGTACBINHLUAN ADD CONSTRAINT FK_TUONGTACBINHLUAN_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND)
ALTER TABLE BAOCAOBINHLUAN ADD CONSTRAINT FK_BAOCAOBINHLUAN_BINHLUAN FOREIGN KEY (MaBL) REFERENCES BINHLUAN(MaBL) ON DELETE CASCADE
ALTER TABLE BAOCAOBINHLUAN ADD CONSTRAINT FK_BAOCAOBINHLUAN_NGUOIDUNG FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND)
GO
------------------------------------------
-- Tao tai khoan
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('phanquiduc','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('tranhoangdanh','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('nguyenhuyvu','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('hothimongtien','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('tonnhatphi','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('nguyenvansi','123',1,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('user1','123',0,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('user2','123',0,1)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('user3','123',0,0)
INSERT INTO TAIKHOAN (TenTK, MatKhau, VaiTro, TrangThai) VALUES	('user4','123',0,0)
GO
--SELECT * FROM TAIKHOAN
GO

------------------------------------------
-- Tao nguoi dung
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Phan Quí Đức', '2000-06-28', 1, 'ducpqps25526@fpt.edu.vn', 'phanquiduc.png', 'phanquiduc')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Trần Hoàng Danh', '2003-11-04', 1, 'danhthps25468@fpt.edu.vn', 'tranhoangdanh.png', 'tranhoangdanh')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Nguyễn Huy Vũ', '2003-11-13', 1, 'vunhps25582@fpt.edu.vn', 'nguyenhuyvu.png', 'nguyenhuyvu')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Hồ Thị Mộng Tiên', '2003-09-01', 0, 'tienhtmps20000@fpt.edu.vn', 'hothimongtien.png', 'hothimongtien')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Tôn Nhật Phi', '2003-08-17', 1, 'phitnps25453@fpt.edu.vn', 'tonnhatphi.png', 'tonnhatphi')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Nguyễn Văn Sĩ', '1993-11-14', 1, 'sinvps25579@fpt.edu.vn', 'nguyenvansi.png', 'nguyenvansi')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Người Dùng Một', '2000-04-24', 0, 'nguoidung100@gmail.com', 'nguyenvansi.png', 'user1')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Người Dùng Hai', '2001-07-11', 0, 'nguoidung200@gmail.com', 'nguyenvansi.png', 'user2')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Người Dùng Ba', '2002-03-08', 1, 'nguoidung300@gmail.com', 'nguyenvansi.png', 'user3')
INSERT INTO NGUOIDUNG (HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (N'Người Dùng Tu', '2002-10-08', 1, 'nguoidung400@gmail.com', 'nguyenvansi.png', 'user4')
GO
--SELECT * FROM NGUOIDUNG
GO
------------------------------------------
-- Tao bai hat
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Lạc trôi', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt', 'lacTroi.txt', 'lacTroi.jpg', 'lacTroi.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Chạy ngay đi', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Rap Việt', 'chayNgayDi.txt', 'chayNgayDi.png', 'chayNgayDi.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Anh sai rồi', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'V-Pop', 'anhSaiRoi.txt', 'anhSaiRoi.jpg', 'anhSaiRoi.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Nắng ấm xa dần', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt, Rap Việt', 'nangAmXaDan.txt', 'nangAmXaDan.jpg', 'nangAmXaDan.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Khuôn mặt đáng thương', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt, Rap Việt', 'khuonMatDangThuong.txt', 'khuonMatDangThuong.jpg', 'khuonMatDangThuong.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Thái bình mồ hôi rơi', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt', 'thaiBinhMoHoiRoi.txt', 'thaiBinhMoHoiRoi.jpg', 'thaiBinhMoHoiRoi.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Không phải dạng vừa đâu', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'EDMt', 'khongPhaiDangVuaDau.txt', 'khongPhaiDangVuaDau.jpg', 'khongPhaiDangVuaDau.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Chấm hết', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Rap Việt', 'chamHet.txt', 'chamHet.jpg', 'chamHet.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Cơn mưa ngang qua', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt', 'conMuaNgangQua.txt', 'conMuaNgangQua.jpg', 'conMuaNgangQua.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Em của ngày hôm qua', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt', 'emCuaNgayHomQua.txt', 'emCuaNgayHomQua.jpg', 'emCuaNgayHomQua.mp3', 1, 1)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Vì anh là của em', N'Khắc Hưng', N'Hòa Minzy',  N'V-Pop', 'viAnhLaCuaEm.txt', 'viAnhLaCuaEm.jpg', 'viAnhLaCuaEm.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Ăn gì đây', N'Khắc Hưng', N'Hòa Minzy', N'Rap Việt', 'anGiDay.txt', 'anGiDay.jpg', 'anGiDay.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Ánh nắng của anh', N'Khắc Hưng', N'Đức Phúc', N'V-Pop', 'anhNangCuaAnh.txt', 'anhNangCuaAnh.jpg', 'anhNangCuaAnh.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Nơi này có anh', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'EDM', 'noiNayCoAnh.txt', 'noiNayCoAnh.jpg', 'noiNayCoAnh.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Chắc ai đó sẽ về', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt, EDM', 'chacAiDoSeVe.txt', 'chacAiDoSeVe.jpg', 'chacAiDoSeVe.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Remember me', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'EDM', 'rememberMe.txt', 'rememberMe.jpg', 'rememberMe.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Tập sống không có em', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Rap Việt', 'tapSongKhongCoEm.txt', 'tapSongKhongCoEm.jpg', 'tapSongKhongCoEm.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Đừng về trễ', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Rnb', 'dungVeTre.txt', 'dungVeTre.jpg', 'dungVeTre.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Chúng ta không thuộc về nhau', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Nhạc trẻ', 'chungTaKhongThuocVeNhau.txt', 'chungTaKhongThuocVeNhau.jpg', 'chungTaKhongThuocVeNhau.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Người khác', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'nguoiKhac.txt', 'nguoiKhac.jpg', 'nguoiKhac.mp3', 1, 2)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Thật may cho anh', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'thatMayChoAnh.txt', 'thatMayChoAnh.jpg', 'thatMayChoAnh.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Mình từng yêu nhau', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'minhTungYeuNhau.txt', 'minhTungYeuNhau.jpg', 'minhTungYeuNhau.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Tự dưng', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'tuDung.txt', 'tuDung.jpg', 'tuDung.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Anh ghét làm bạn em', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'anhGhetLamBanEm.txt', 'anhGhetLamBanEm.jpg', 'anhGhetLamBanEm.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Nắng mùa hạ', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'nangMuaHa.txt', 'nangMuaHa.jpg', 'nangMuaHa.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Nước ngoài', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'nuocNgoai.txt', 'nuocNgoai.jpg', 'nuocNgoai.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Khi người mình yêu khóc', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'khiNguoiMinhYeuKhoc.txt', 'khiNguoiMinhYeuKhoc.jpg', 'khiNguoiMinhYeuKhoc.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Tự kỷ', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'tuKy.txt', 'tuKy.jpg', 'tuKy.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Có chàng trai viết lên cây', N'Phan Mạnh Quỳnh', N'Phan Mạnh Quỳnh', N'Nhạc trẻ', 'coChangTraiVietLenCay.txt', 'coChangTraiVietLenCay.jpg', 'coChangTraiVietLenCay.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Em mới là người yêu anh', N'Khắc Hưng', N'MIN', N'Nhạc trẻ', 'emMoiLaNguoiYeuAnh.txt', 'emMoiLaNguoiYeuAnh.jpg', 'emMoiLaNguoiYeuAnh.mp3', 1, 3)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Vì tôi còn sống', N'Tiên Tiên', N'Tiên Tiên', N'Nhạc trẻ', 'viToiConSong.txt', 'viToiConSong.jpg', 'viToiConSong.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Buồn không em', N'Đạt G', N'Đạt G', N'Nhạc trẻ', 'buonKhongEm.txt', 'buonKhongEm.jpg', 'buonKhongEm.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Điều khác lạ', N'Đạt G', N'Ngọc Haleyy, Đạt G', N'Nhạc trẻ', 'dieuKhacLa.txt', 'dieuKhacLa.jpg', 'dieuKhacLa.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'2 Sugar feat ayra starr', N'Wizkid', N'Wizkid', N'Rap', '2SugarFeatAyraStarr.txt', '2SugarFeatAyraStarr.jpg', '2SugarFeatAyraStarr	.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'7 Rings', N'Ariana Graden', N'Ariana Graden', N'Pop', '7Rings.txt', '7Rings.jpg', '7Rings.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'72 Seasons', N'Metallica', N'Metallica', N'Dance Việt', '72Seasons.txt', '72Seasons.jpg', '72Seasons.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Again', N'Mac Ayres', N'Mac Ayres', N'Blues', 'again.txt', 'again.jpg', 'again.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'America hasaproblem', N'Beyonce', N'Beyonce', N'Blues', 'americaHasaproblem.txt', 'americaHasaproblem.jpg', 'americaHasaproblem.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Breaking point', N'Leon Thomas', N'Leon Thomas', N'Blues', 'breakingPoint.txt', 'breakingPoint.jpg', 'breakingPoint.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Calm & Patient', N'Jhene Aiko', N'Jhene Aiko', N'Blues', 'calm&Patient.txt', 'calm&Patient.jpg', 'calm&Patient.mp3', 1, 4)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Cheat pack', N'Chloe', N'Chloe', N'Pop', 'cheatBack.txt', 'cheatBack.jpg', 'cheatBack.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Chúng ta của hiện tại', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'V-Pop', 'chungTaCuaHienTai.txt', 'chungTaCuaHienTai.jpg', 'chungTaCuaHienTai.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Cuffit wetter remix', N'Beyonce', N'Beyonce', N'Remix', 'cuffitWetterRemix.txt', 'cuffitWetterRemix.jpg', 'cuffitWetterRemix.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Curious feat fabolous', N'Eric Bellingger', N'Eric Bellingger', N'Rap', 'curiousFeatFabolous.txt', 'curiousFeatFabolous.jpg', 'curiousFeatFabolous.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Demon time with ariLennox remix', N'Alex Vaughn', N'Alex Vaughn', N'Remix', 'demonTimeWithAriLennoxRemix.txt', 'demonTimeWithAriLennoxRemix.jpg', 'demonTimeWithAriLennoxRemix.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Die for you remix', N'The Weeknd', N'The Weeknd', N'Remix', 'dieForYouRemix.txt', 'dieForYouRemix.jpg', 'dieForYouRemix.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Ditto', N'Newjeans', N'Newjeans', N'K-Pop', 'ditto.txt', 'ditto.jpg', 'ditto.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Do 4 love', N'Snoh Aalegra', N'Snoh Aalegra', N'Blues', 'do4Love.txt', 'do4Love.jpg', 'do4Love.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Dont start now', N'Dua Lipa', N'Dua Lipa', N'Pop', 'dontStartNow.txt', 'dontStartNow.jpg', 'dontStartNow.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Dont stop', N'GoGo Morow', N'GoGo Morow', N'Blues', 'dontStop.txt', 'dontStop.jpg', 'dontStop.mp3', 1, 5)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Dont wanna cry', N'SEVENTEEN', N'SEVENTEEN', N'K-Pop', 'dontWannaCry.txt', 'dontWannaCry.jpg', 'dontWannaCry.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Do you mind', N'Vedo', N'Vedo', N'Jazz', 'doYouMind.txt', 'doYouMind.jpg', 'doYouMind.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Đưa nhau đi trốn', N'Đen', N'Đen', N'Rap', 'duaNhauDiTron.txt', 'duaNhauDiTron.jpg', 'duaNhauDiTron.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Em là', N'Mono', N'Mono', N'V-Pop', 'emLa.txt', 'emLa.jpg', 'emLa.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Enough for love', N'Kelela', N'Kelela', N'R&B', 'enoughForLove.txt', 'enoughForLove.jpg', 'enoughForLove.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Feature me', N'FLO', N'FLO', N'R&B', 'featureMe.txt', 'featureMe.jpg', 'featureMe.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Fight for love', N'SAULT', N'SAULT', N'Blues', 'fightForLove.txt', 'fightForLove.jpg', 'fightForLove.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Flower', N'Jisoo', N'Jisoo', N'K-Pop', 'flower.txt', 'flower.jpg', 'flower.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Fly girl', N'FLO', N'FLO', N'Pop', 'flyGirl.txt', 'flyGirl.jpg', 'flyGirl.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Forever', N'Jessie Reyez', N'Jessie Reyez', N'Blues', 'forever.txt', 'forever.jpg', 'forever.mp3', 1, 6)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Glu', N'Usher', N'Usher', N'Blues', 'glu.txt', 'glu.jpg', 'glu.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Goose bumps', N'Travis Scott', N'Travis Scott', N'Rap', 'gooseBumps.txt', 'gooseBumps.jpg', 'gooseBumps.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'How does it feel', N'Chole', N'Chole', N'Blues', 'howDoesItFeel.txt', 'howDoesItFeel.jpg', 'howDoesItFeel.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Icu', N'Coco Jones', N'Coco Jones', N'R&B', 'icu.txt', 'icu.jpg', 'icu.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Im baby', N'Ambre', N'Ambre', N'Jazz', 'imBaby.txt', 'imBaby.jpg', 'imBaby.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'I wish you roses', N'Kali Uchis', N'Kali Uchis', N'Jazz', 'iWishYouRoses.txt', 'iWishYouRoses.jpg', 'iWishYouRoses.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Jackiebrown', N'Brent Faiyas', N'Brent Faiyas', N'Pop', 'jackiebrown.txt', 'jackiebrown.jpg', 'jackiebrown.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Let me go', N'Daniel Caesar', N'Daniel Caesar', N'Dance', 'letMeGo.txt', 'letMeGo.jpg', 'letMeGo.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Like her too', N'Mario', N'Mario', N'Jazz', 'likeHerToo.txt', 'likeHerToo.jpg', 'likeHerToo.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Like that', N'Doja Cat', N'Doja Cat', N'Pop', 'likeThat.txt', 'likeThat.jpg', 'likeThat.mp3', 1, 7)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Love language', N'SZA', N'SZA', N'R&B', 'loveLanguage.txt', 'loveLanguage.jpg', 'loveLanguage.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Mad riches', N'Dancho', N'Dancho', N'Blues', 'madRiches.txt', 'madRiches.jpg', 'madRiches.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Ouu ahh', N'Mannywwellz', N'Mannywwellz', N'Jazz', 'ouuAhh.txt', 'ouuAhh.jpg', 'ouuAhh.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Play date', N'Melanie Martinez', N'Melanie Martinez', N'Jazz', 'playDate.txt', 'playDate.jpg', 'playDate.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Santorini', N'Chritian Kuria', N'Chritian Kuria', N'Jazz', 'santorini.txt', 'santorini.jpg', 'santorini.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Save your soul', N'Tink', N'Tink', N'R&B', 'saveYourSoul.txt', 'saveYourSoul.jpg', 'saveYourSoul.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Say so', N'Doja Cat', N'Doja Cat', N'Pop', 'saySo.txt', 'saySo.jpg', 'saySo.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Shadows', N'Creed', N'Creed', N'Dance', 'shadows.txt', 'shadows.jpg', 'shadows.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Shirt', N'SZA', N'SZA', N'R&B', 'shirt.txt', 'shirt.jpg', 'shirt.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Smoke', N'Victoria', N'Victoria', N'R&B', 'smoke.txt', 'smoke.jpg', 'smoke.mp3', 1, 8)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Snooze', N'SZA', N'SZA', N'R&B', 'snooze.txt', 'snooze.jpg', 'snooze.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'So be it', N'Alex Vaughn', N'Alex Vaughn', N'Blues', 'soBeIt.txt', 'soBeIt.jpg', 'soBeIt.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Bad guy', N'Billiie Eilish', N'Billiie Eilish', N'Pop', 'badGuy.txt', 'badGuy.jpg', 'badGuy.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Yummy', N'Justin Bieber', N'Justin Bieber', N'Pop', 'yummy.txt', 'yummy.jpg', 'yummy.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Sure thing', N'Miguel', N'Miguel', N'Blues', 'sureThing.txt', 'sureThing.jpg', 'sureThing.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Thank U next', N'Ariana Graden', N'Ariana Graden', N'Pop', 'thankUNext.txt', 'thankUNext.jpg', 'thankUNext.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'N-Sao', N'Suboi', N'Suboi', N'Rap', 'n-Sao.txt', 'n-Sao.jpg', 'n-Sao.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Ghệ iu dấu của em ơi', N'Tlinh', N'Tlinh', N'Melody', 'gheIuDauCuaEmOi.txt', 'gheIuDauCuaEmOi.jpg', 'gheIuDauCuaEmOi.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Nếu lúc đó', N'Tlinh', N'Tlinh', N'Melody', 'neuLucDo.txt', 'neuLucDo.jpg', 'neuLucDo.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'This is', N'Ella Mai', N'Ella Mai', N'Blues', 'thisIs.txt', 'thisIs.jpg', 'thisIs.mp3', 1, 9)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Until the end of time', N'Leon Thomas', N'Coco jones', N'Reggae', 'untilTheEndOfTime.txt', 'untilTheEndOfTime.jpg', 'untilTheEndOfTime.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Used to me', N'Ty Dolla Sign', N'Mario', N'Jazz', 'usedToMe.txt', 'usedToMe.jpg', 'usedToMe.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Valentina', N'Daniel Caesar', N'Daniel Caesar', N'Jazz', 'valentina.txt', 'valentina.jpg', 'valentina.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Waiting for you', N'Onionn', N'Mono', N'V-Pop', 'waitingForYou.txt', 'waitingForYou.jpg', 'waitingForYou.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Waste my time', N'Sơn Tùng MTAri LennoxP', N'Ari Lennox', N'R&B', 'wasteMyTime.txt', 'wasteMyTime.jpg', 'wasteMyTime.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'What it is', N'Doechii', N'Doechii', N'Jazz', 'whatItIs.txt', 'whatItIs.jpg', 'whatItIs.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'We might even be falling in love', N'Bryson Tiller', N'Victoria Monet', N'Reggae', 'weMightEvenBeFallingInLove.txt', 'weMightEvenBeFallingInLove.jpg', 'weMightEvenBeFallingInLove.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'What you wanna try', N'Masego', N'Masego', N'Hiphop', 'whatYouWannaTry.txt', 'whatYouWannaTry.jpg', 'whatYouWannaTry.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Where i go', N'NxWorrries', N'NxWorrries', N'Jazz', 'whereIGo.txt', 'whereIGo.jpg', 'whereIGo.mp3', 1, 10)
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'White Rice Déjà Vuu', N'Musig Soulchild', N'Hit-boy', N'Blues', 'whiteRiceDejaVuu.txt', 'whiteRiceDejaVuu.jpg', 'whiteRiceDejaVuu.mp3', 1, 10)
GO
INSERT INTO BAIHAT (TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (N'Lạc trôi', N'Sơn Tùng MTP', N'Sơn Tùng MTP', N'Dance Việt', 'lacTroi.txt', 'lacTroi.jpg', 'lacTroi.mp3', 0, 1)
--SELECT * FROM BAIHAT
GO

------------------------------------------
-- Tao playlist 
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Giật Lofi', 0,'nhacGiatLofi.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Nhẹ Remix', 0,'nhacNheRemix.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Ngoại  Lời Việt', 0,'nhacNgoaiLoiViet.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Ru Ngủ', 0,'nhacRuNgu.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Trữ Tình Lofi', 0,'nhacTruTinhLofi.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Trữ Tình Remix', 0,'nhacTruTinhRemix.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Playlist Này 10 Điểm Nha Thầy', 0,'playlistNay10DiemNhaThay.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Vui Vẻ', 0,'nhacVuiVe.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Buồn', 0,'nhacBuon.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Tâm Trạng', 0,'nhacTamTrang.jpg', 1)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Playlist Không Tên', 0,'playlistKhongTen.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Vàng Huyền Thoại', 0,'nhacVangHuyenThoai.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Rap Không Lời', 0,'nhacRapKhongLoi.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Làm Việc Đêm Khuya', 0,'nhacLamViecDemKhuya.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Đồng Quê', 0,'nhacDongQue.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Popcorn', 0,'nhacPopcorn.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Thượng Đẳng', 0,'nhacThuongDang.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Chua', 0,'nhacChua.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc 7 Anh Em Siêu Nhân', 0,'nhac7AnhEmSieuNhan.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Adelete', 0,'nhacAdelete.jpg', 2)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Mũi', 0,'nhacMui.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Hay 2077', 0,'nhacHay2077.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Không Nhạc', 0,'nhacKhongNhac.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Indie', 0,'nhacIndie.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Tiktok', 0,'nhacTiktok.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Đạo', 0,'nhacDao.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Phim', 0,'nhacPhim.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Thiền', 0,'nhacThien.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Dân Gian', 0,'nhacDanGian.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'99%', 0,'99%.jpg', 3)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'42 Độ Album', 0,'42DoAlbum.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Hoàng', 0,'hoang.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Link', 0,'link.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Midnight', 0,'midnight.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'HipHop', 0,'hipHop.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Mới', 0,'nhacMoi.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Opera', 0,'nhacOpera.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Cổ Điển', 0,'nhacCoDien.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Hoài Niệm', 0,'nhacHoaiNiem.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc', 0,'nhac.jpg', 4)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Lowkey', 0,'lowkey.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Nghe Xong Xóa', 0,'nhacNgheXongXoa.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Mono', 0,'nhacMono.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc GDragon', 0,'nhacGDragon.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Văn Mai Hương Album', 0,'vanMaiHuongAlbum.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Đen Hồng', 0,'denHong.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Quần Jean Mới', 0,'quanJeanMoi.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'17', 0,'17.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Đen Vâu', 0,'denVau.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Hào Khi Anh Hùng', 0,'haoKhiAnhHung.jpg', 5)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Chiến Binh Cầu Vồng', 0,'chienBinhCauVong.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Tâm trạng 2023', 0,'tamTrang2023.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Lũ', 0,'nhacLu.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Sến', 0,'nhacSen.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Riêng Tư', 0,'nhacRiengTu.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Dân Tộc', 0,'nhacDanToc.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Cách Mạng', 0,'nhacCachMang.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Game', 0,'nhacGame.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Vũ Trường', 0,'nhacVuTruong.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Xuống Bar 10 Giờ', 0,'xuongBar10Gio.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Chill', 0,'nhacChill.jpg', 6)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Lời Quẩy Không Nhạc', 0,'loiQuayKhongNhac.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Chuông', 0,'nhacChuong.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Bolero', 0,'bolero.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Hải Ngoại', 0,'haiNgoai.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc 20/11', 0,'nhac2011.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Quốc Khánh', 0,'nhacQuocKhanh.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Tây Nguyên', 0,'nhacTayNguyen.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Album Tiếng Động Vật', 0,'albumTiengDongVat.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Instrumental', 0,'instrumental.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Chùa', 0,'nhacChua.jpg', 7)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Rap Diz', 0,'rapDiz.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Trend', 0,'trend.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'1%', 0,'1%.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'EDM', 0,'EDM.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Đỏ', 0,'nhacDo.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Mashup', 0,'mashup.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'jazz', 0,'jazz.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Country House', 0,'countryHouse.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Cãi Lương', 0,'caiLuong.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Pháp', 0,'nhacPhap.jpg', 8)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Nga', 0,'nhacNga.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Latin', 0,'nhacLatin.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Những Bài Hát Cover', 0,'nhungBaiHatCover.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Ấn Độ', 0,'nhacAnDo.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Hoàng Thùy Linh', 0,'hoangThuyLinh.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Study With Me', 0,'studyWithMe.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Speed Up', 0,'speedUp.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Trung', 0,'nhacTrung.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Quay Về Tuổi Thơ', 0,'quayVeTuoiTho.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Blues', 0,'nhacBlues.jpg', 9)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Acoustic', 0,'nhacAcoustic.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Dance', 0,'nhacDance.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Rnb', 0,'nhacRnb.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Đương Đại', 0,'nhacĐuongai.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Underground', 0,'nhacUnderground.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Trừu Tượng', 0,'nhactruuTuong.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Disco', 0,'nhacDisco.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Jpop', 0,'nhacJpop.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Dễ Nghe', 0,'nhacDeNghe.jpg', 10)
INSERT INTO PLAYLIST (TenPlayList, RiengTu, HinhAnh, MaND) VALUES (N'Nhạc Dễ Ngủ', 0,'nhacDeNgu.jpg', 10)
GO
--SELECT * FROM PLAYLIST
GO

------------------------------------------
-- Tao bai hat playlist
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (1, 1)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (1, 2)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (1, 3)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (1, 4)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (1, 5)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (2, 6)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (2, 7)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (2, 8)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (2, 9)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (2, 10)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (3, 11)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (3, 12)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (3, 13)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (3, 14)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (3, 15)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (4, 16)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (4, 17)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (4, 18)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (4, 19)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (4, 20)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (5, 21)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (5, 22)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (5, 23)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (5, 24)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (5, 25)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (6, 26)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (6, 27)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (6, 28)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (6, 29)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (6, 30)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (7, 31)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (7, 32)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (7, 33)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (7, 34)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (7, 35)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (8, 36)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (8, 37)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (8, 38)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (8, 39)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (8, 40)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (9, 41)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (9, 42)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (9, 43)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (9, 44)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (9, 45)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (10, 46)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (10, 47)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (10, 48)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (10, 49)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (10, 50)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (11, 51)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (11, 52)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (11, 53)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (11, 54)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (11, 55)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (12, 56)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (12, 57)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (12, 58)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (12, 59)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (12, 60)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (13, 61)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (13, 62)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (13, 63)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (13, 64)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (13, 65)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (14, 66)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (14, 67)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (14, 68)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (14, 69)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (14, 70)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (15, 71)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (15, 72)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (15, 73)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (15, 74)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (15, 75)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (16, 76)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (16, 77)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (16, 78)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (16, 79)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (16, 80)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (17, 81)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (17, 82)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (17, 83)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (17, 84)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (17, 85)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (18, 86)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (18, 87)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (18, 88)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (18, 89)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (18, 90)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (19, 91)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (19, 92)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (19, 93)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (19, 94)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (19, 95)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (20, 96)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (20, 97)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (20, 98)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (20, 99)
INSERT INTO BAIHATPLAYLIST (MaPlayList, MaBH) VALUES (20, 100)
GO
--SELECT * FROM BAIHATPLAYLIST
GO


------------------------------------------
-- Tao bai hat yeu thich
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (1, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (1, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (1, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (1, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (1, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (2, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (2, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (2, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (2, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (2, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (3, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (3, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (3, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (3, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (3, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (4, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (4, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (4, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (4, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (4, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (5, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (5, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (5, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (5, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (5, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (6, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (6, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (6, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (6, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (6, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (7, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (7, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (7, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (7, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (7, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (8, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (8, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (8, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (8, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (8, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (9, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (9, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (9, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (9, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (9, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (10, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (10, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (10, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (10, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (10, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (11, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (11, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (11, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (11, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (11, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (12, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (12, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (12, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (12, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (12, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (13, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (13, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (13, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (13, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (13, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (14, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (14, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (14, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (14, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (14, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (15, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (15, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (15, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (15, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (15, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (16, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (16, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (16, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (16, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (16, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (17, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (17, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (17, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (17, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (17, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (18, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (18, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (18, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (18, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (18, 10)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (19, 1)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (19, 2)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (19, 3)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (19, 4)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (19, 5)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (20, 6)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (20, 7)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (20, 8)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (20, 9)
INSERT INTO BAIHATYEUTHICH (MaBH, MaND) VALUES (20, 10)
GO
--SELECT * FROM BAIHATYEUTHICH
GO


------------------------------------------
-- Tao luot nghe
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (1, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (1, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (1, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (1, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (1, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (2, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (2, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (2, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (2, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (2, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (3, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (3, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (3, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (3, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (3, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (4, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (4, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (4, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (4, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (4, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (5, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (5, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (5, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (5, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (5, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (6, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (6, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (6, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (6, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (6, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (7, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (7, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (7, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (7, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (7, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (8, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (8, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (8, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (8, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (8, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (9, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (9, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (9, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (9, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (9, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (10, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (10, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (10, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (10, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (10, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (11, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (11, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (11, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (11, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (11, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (12, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (12, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (12, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (12, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (12, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (13, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (13, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (13, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (13, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (13, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (14, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (14, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (14, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (14, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (14, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (15, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (15, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (15, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (15, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (15, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (16, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (16, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (16, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (16, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (16, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (17, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (17, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (17, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (17, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (17, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (18, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (18, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (18, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (18, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (18, 10)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (19, 1)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (19, 2)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (19, 3)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (19, 4)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (19, 5)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (20, 6)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (20, 7)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (20, 8)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (20, 9)
INSERT INTO LUOTNGHE (MaBH, MaND) VALUES (20, 10)
GO
--SELECT * FROM LUOTNGHE
GO

------------------------------------------
-- Tao luot yeu thich
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (1, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (1, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (1, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (1, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (1, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (2, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (2, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (2, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (2, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (2, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (3, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (3, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (3, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (3, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (3, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (4, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (4, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (4, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (4, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (4, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (5, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (5, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (5, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (5, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (5, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (6, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (6, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (6, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (6, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (6, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (7, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (7, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (7, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (7, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (7, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (8, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (8, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (8, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (8, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (8, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (9, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (9, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (9, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (9, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (9, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (10, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (10, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (10, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (10, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (10, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (11, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (11, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (11, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (11, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (11, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (12, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (12, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (12, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (12, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (12, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (13, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (13, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (13, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (13, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (13, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (14, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (14, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (14, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (14, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (14, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (15, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (15, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (15, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (15, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (15, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (16, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (16, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (16, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (16, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (16, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (17, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (17, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (17, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (17, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (17, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (18, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (18, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (18, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (18, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (18, 10)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (19, 1)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (19, 2)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (19, 3)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (19, 4)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (19, 5)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (20, 6)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (20, 7)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (20, 8)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (20, 9)
INSERT INTO LUOTYEUTHICH (MaBH, MaND) VALUES (20, 10)
GO
--SELECT * FROM LUOTYEUTHICH
GO


------------------------------------------
-- Tao luot yeu thich playlist
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (1, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (1, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (1, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (1, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (1, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (2, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (2, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (2, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (2, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (2, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (3, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (3, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (3, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (3, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (3, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (4, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (4, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (4, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (4, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (4, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (5, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (5, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (5, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (5, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (5, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (6, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (6, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (6, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (6, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (6, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (7, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (7, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (7, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (7, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (7, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (8, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (8, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (8, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (8, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (8, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (9, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (9, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (9, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (9, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (9, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (10, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (10, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (10, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (10, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (10, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (11, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (11, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (11, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (11, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (11, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (12, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (12, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (12, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (12, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (12, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (13, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (13, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (13, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (13, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (13, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (14, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (14, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (14, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (14, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (14, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (15, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (15, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (15, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (15, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (15, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (16, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (16, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (16, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (16, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (16, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (17, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (17, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (17, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (17, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (17, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (18, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (18, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (18, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (18, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (18, 10)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (19, 1)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (19, 2)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (19, 3)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (19, 4)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (19, 5)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (20, 6)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (20, 7)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (20, 8)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (20, 9)
INSERT INTO LUOTYEUTHICHPLAYLIST (MaPlayList, MaND) VALUES (20, 10)
GO
--SELECT * FROM LUOTYEUTHICHPLAYLIST
GO


------------------------------------------
-- Tao binh luan
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 1, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 1, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 1, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 1, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 1, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 2, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 2, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 2, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 2, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 2, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 3, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 3, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 3, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 3, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 3, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 4, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 4, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 4, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 4, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 4, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 5, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 5, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 5, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 5, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 5, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 6, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 6, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 6, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 6, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 6, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 7, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 7, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 7, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 7, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 7, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 8, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 8, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 8, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 8, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 8, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 9, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 9, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 9, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 9, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 9, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 10, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 10, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 10, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 10, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 10, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 11, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 11, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 11, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 11, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 11, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 12, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 12, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 12, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 12, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 12, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 13, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 13, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 13, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 13, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 13, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 14, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 14, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 14, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 14, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 14, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 15, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 15, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 15, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 15, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 15, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 16, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 16, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 16, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 16, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 16, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 17, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 17, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 17, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 17, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 17, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 18, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 18, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 18, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 18, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 18, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 19, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 19, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 19, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 19, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'Chill cực!', 19, 5)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (1, N'Bài hát này hay quá!', 20, 1)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (2, N'Hay quá!!!', 20, 2)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (3, N'Tuyệt vời!', 20, 3)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (4, N'Đỉnh!', 20, 4)
INSERT INTO BINHLUAN (STT, NoiDung, MaBH, MaND) VALUES (5, N'*** ****!', 20, 5)
GO
--SELECT * FROM BINHLUAN
GO


------------------------------------------
-- Tao tuong tac binh luan
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (1, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (1, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (1, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (1, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (1, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (2, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (2, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (2, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (2, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (2, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (3, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (3, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (3, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (3, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (3, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (4, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (4, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (4, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (4, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (4, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (5, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (5, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (5, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (5, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (5, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (6, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (6, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (6, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (6, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (6, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (7, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (7, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (7, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (7, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (7, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (8, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (8, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (8, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (8, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (8, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (9, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (9, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (9, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (9, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (9, 5, 0)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (10, 1, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (10, 2, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (10, 3, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (10, 4, 1)
INSERT INTO TUONGTACBINHLUAN (MaBL, MaND, TrangThai) VALUES (10, 5, 0)
GO
--SELECT * FROM TUONGTACBINHLUAN
GO


------------------------------------------
-- Tao bao cao binh luan
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (11, 1)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (12, 2)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (13, 3)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (14, 4)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (15, 5)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (16, 6)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (17, 7)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (18, 8)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (19, 9)
INSERT INTO BAOCAOBINHLUAN (MaBL, MaND) VALUES (20, 10)
GO
--SELECT * FROM BAOCAOBINHLUAN
GO



-------------------------
if OBJECT_ID('proc_thongKeLuotNghe') is not null
	drop proc proc_thongKeLuotNghe
go

create proc proc_thongKeLuotNghe
as
begin
	select BAIHAT.MaBH, BAIHAT.TenBH, BAIHAT.HinhAnh, COUNT(LUOTNGHE.MaBH) as 'TongNghe' from LUOTNGHE right join BAIHAT on LUOTNGHE.MaBH = BAIHAT.MaBH
	group by BAIHAT.MaBH, BAIHAT.TenBH, BAIHAT.HinhAnh
end
go

-------------------------
if OBJECT_ID('proc_thongKeLuotThich') is not null
	drop proc proc_thongKeLuotThich
go

create proc proc_thongKeLuotThich
as
begin
	select BAIHAT.MaBH, BAIHAT.TenBH, BAIHAT.HinhAnh, COUNT(LUOTYEUTHICH.MaBH) as 'TongLike' from LUOTYEUTHICH right join BAIHAT on LUOTYEUTHICH.MaBH = BAIHAT.MaBH
	group by BAIHAT.MaBH, BAIHAT.TenBH, BAIHAT.HinhAnh
end
go

exec proc_thongKeLuotNghe 
-------------------------
--if OBJECT_ID('proc_xepHangTrending') is not null
--	drop proc proc_xepHangTrending
--go

--create proc proc_xepHangTrending
--as
--begin
--	select COUNT(MaBH) from LUOTYEUTHICH where MaBH = @MaBH
--end
--go

-------------------------
if OBJECT_ID('proc_xepHang100Playlist') is not null
	drop proc proc_xepHang100Playlist
go

create proc proc_xepHang100Playlist
	@NgayTuanThang INT
as
begin
	declare @tbYeuThichXaNhat table (
		MaPlayList INT NOT NULL,
		Time DATETIME
	)
	if @NgayTuanThang = 1
	begin
		insert into @tbYeuThichXaNhat
			select MaPlayList, CONVERT(datetime,MAX(Time)) as 'ThoiGianXaNhat' from LUOTYEUTHICHPLAYLIST
			where DATEDIFF(second, LUOTYEUTHICHPLAYLIST.Time,GETDATE()) <= (60*60*24) -- số giây của 1 ngày
			group by MaPlayList
	end
	if @NgayTuanThang = 7
	begin
		insert into @tbYeuThichXaNhat
			select MaPlayList, CONVERT(datetime,MAX(Time)) as 'ThoiGianXaNhat' from LUOTYEUTHICHPLAYLIST
			where DATEDIFF(second, LUOTYEUTHICHPLAYLIST.Time,GETDATE()) <= (7*60*60*24) -- số giây của 7 ngày
			group by MaPlayList
	end
	if @NgayTuanThang = 30
	begin
		insert into @tbYeuThichXaNhat
			select MaPlayList, CONVERT(datetime,MAX(Time)) as 'ThoiGianXaNhat' from LUOTYEUTHICHPLAYLIST
			where DATEDIFF(second, LUOTYEUTHICHPLAYLIST.Time,GETDATE()) <= (30*60*60*24) -- số giây của 30 ngày
			group by MaPlayList
	end
	select top 100 
		PLAYLIST.MaPlayList, PLAYLIST.TenPlayList, PLAYLIST.HinhAnh, COUNT(tb.MaPlayList) as 'TongLike' from @tbYeuThichXaNhat as tb 
		left join PLAYLIST on tb.MaPlayList = PLAYLIST.MaPlayList
		left join LUOTYEUTHICHPLAYLIST on tb.MaPlayList = LUOTYEUTHICHPLAYLIST.MaPlayList
		where RiengTu = 0 and DATEDIFF(SECOND, tb.Time, GETDATE()) <= (60*60*24) -- số giây của 1 ngày
		group by PLAYLIST.MaPlayList, PLAYLIST.TenPlayList, PLAYLIST.HinhAnh
		order by TongLike
end
go


--select MaBH, COUNT(MaBH) AS A from  LUOTNGHE WHERE Time =  GROUP BY MaBH
--select MaBH, COUNT(MaBH) AS A from  LUOTYEUTHICH GROUP BY MaBH

--DECLARE @A DATE = GETDATE()
--select DATEDIFF(HOUR, '02:00:00', DATEPART(hour, GETDATE()))

--go

--SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTNGHE ON BAIHAT.MaBH = LUOTNGHE.MaBH GROUP BY BAIHAT.MaBH
--SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTYEUTHICH ON BAIHAT.MaBH = LUOTYEUTHICH.MaBH GROUP BY BAIHAT.MaBH

--GO

if OBJECT_ID('Trending') is not null
	drop proc Trending
go

CREATE proc Trending
AS
begin
	DECLARE @tblLove TABLE (
		MaBH INT NOT NULL,
		LuotTim INT
	);
	DECLARE @tblListen TABLE (
		MaBH INT NOT NULL,
		LuotNghe INT
	);
	--DECLARE @tblLike TABLE(
	--	MaBH INT NOT NULL,
	--	LuotLike BIT
	--);

	INSERT INTO @tblListen 
	SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTNGHE ON BAIHAT.MaBH = LUOTNGHE.MaBH GROUP BY BAIHAT.MaBH

	INSERT INTO @tblLove 
	SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTYEUTHICH ON BAIHAT.MaBH = LUOTYEUTHICH.MaBH GROUP BY BAIHAT.MaBH

	--INSERT INTO @tblLike
	--SELECT FROM BAIHATYEUTHICH JOIN NGUOIDUNG ON BAIHATYEUTHICH.MaND = NGUOIDUNG

	SELECT LI.MaBH,LI.LuotNghe,  (LOG10(LuotTim) + (LOG10(LuotNghe)/10) + (DATEDIFF(second,'1970-01-01 00:00:00', NgayDang) - 1679245200) / 36000)  AS Trending
	FROM @tblListen LI
		JOIN @tblLove LO ON LI.MaBH = LO.MaBH 
		JOIN BAIHAT BH ON LI.MaBH = BH.MaBH
		--JOIN BAIHATYEUTHICH BHYT ON BHYT.MaBH = LI.MaBH
		
	ORDER BY trending DESC
end
go


EXEC Trending 


------------------------------------------------------
if OBJECT_ID('DelAllWithAccount') is not null
	drop trigger DelAllWithAccount
go

create trigger DelAllWithAccount on TAIKHOAN instead of delete
as
	begin
		declare @mand varchar(20) = (select MaND from NGUOIDUNG where TenTK = (select TenTK from deleted))
		delete from BAOCAOBINHLUAN where MaND = @mand
		delete from TUONGTACBINHLUAN where MaND = @mand
		delete from LUOTYEUTHICH where MaND = @mand
		delete from LUOTNGHE where MaND = @mand
		delete from BAIHATYEUTHICH where MaND = @mand
		delete from NGUOIDUNG where MaND = @mand
		delete from TAIKHOAN where TenTK = (select TenTK from deleted)
	end
go


----------------------------------------------------------
if OBJECT_ID('proc_deXuatTimKiem') is not null
	drop proc proc_deXuatTimKiem
go

create proc proc_deXuatTimKiem (@Data nvarchar(100))
as
begin
	declare @search table (
		dataSearch nvarchar(100)
	)
	begin
		insert into @search
			select TenBH from BAIHAT
			where (TenBH like '%'+@Data+'%') or (CaSi like '%'+@Data+'%') or (NhacSi like '%'+@Data+'%') or (TheLoai like '%'+@Data+'%')
	end

	begin
		insert into @search
			select TenPlayList from PLAYLIST
			where (TenPlayList like '%'+@Data+'%')
	end

	select * from @search
end
go

exec proc_deXuatTimKiem N'an'



















