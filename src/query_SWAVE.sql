use SWAVE
go

-------------------------
if OBJECT_ID('proc_thongKeLuotNghe') is not null
	drop proc proc_thongKeLuotNghe
go

create proc proc_thongKeLuotNghe
	@MaBH INT
as
begin
	select BAIHAT.MaBH, BAIHAT.TenBH, COUNT(LUOTNGHE.MaBH) as 'TongNghe' from LUOTNGHE join BAIHAT on LUOTNGHE.MaBH = BAIHAT.MaBH
	group by BAIHAT.MaBH, BAIHAT.TenBH
end
go

-------------------------
if OBJECT_ID('proc_thongKeLuotThich') is not null
	drop proc proc_thongKeLuotThich
go

create proc proc_thongKeLuotThich
as
begin
	select BAIHAT.MaBH, BAIHAT.TenBH, COUNT(LUOTYEUTHICH.MaBH) as 'TongLike' from LUOTYEUTHICH join BAIHAT on LUOTYEUTHICH.MaBH = BAIHAT.MaBH
	group by BAIHAT.MaBH, BAIHAT.TenBH
end
go

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

CREATE PROCEDURE Trending
	@MaNguoiDung INT
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
	DECLARE @tblLike TABLE(
		MaBH INT NOT NULL,
		LuotLike BIT
	);

	INSERT INTO @tblListen 
	SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTNGHE ON BAIHAT.MaBH = LUOTNGHE.MaBH GROUP BY BAIHAT.MaBH

	INSERT INTO @tblLove 
	SELECT BAIHAT.MaBH,  COUNT(BAIHAT.MaBH) FROM BAIHAT JOIN LUOTYEUTHICH ON BAIHAT.MaBH = LUOTYEUTHICH.MaBH GROUP BY BAIHAT.MaBH

	INSERT INTO @tblLike
	SELECT FROM BAIHATYEUTHICH JOIN NGUOIDUNG ON BAIHATYEUTHICH.MaND = NGUOIDUNG

	SELECT LI.MaBH,LI.LuotNghe,  (LOG10(LuotTim) + (LOG10(LuotNghe)/10) + (DATEDIFF(second,'1970-01-01 00:00:00', NgayDang) - 1679245200) / 36000),  AS Trending
	FROM @tblListen LI
		JOIN @tblLove LO ON LI.MaBH = LO.MaBH 
		JOIN BAIHAT BH ON LI.MaBH = BH.MaBH
		JOIN BAIHATYEUTHICH BHYT ON BHYT.MaBH = LI.MaBH
		
	ORDER BY trending DESC
end
go
EXEC Trending 1

create function 