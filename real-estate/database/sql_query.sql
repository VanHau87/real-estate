--Lấy những giá trị tồn tại trong cả 2 bảng theo buildingid
SELECT * FROM building b INNER JOIN assignedbuilding ab ON b.buildingid = ab.buildingid ORDER BY b.buildingid ASC;

--Lấy tất cả bảng bên trái, bảng bên phải chỉ lấy những giá trị tồn tại trong bảng bên trái theo buildingid
SELECT * FROM building b LEFT JOIN assignedbuilding ab ON b.buildingid = ab.buildingid ORDER BY b.buildingid ASC;

--tìm theo gần giống: like '%_%'; không phân biệt hoa hay thường
SELECT * FROM building b WHERE b.name LIKE '%tower%';

--TRUY VẤN THEO NHIỀU ĐIỀU KIỆN
SELECT * FROM building b INNER JOIN assignedbuilding ab ON b.buildingid = ab.buildingid WHERE
	b.name LIKE '%BUILDING%' AND b.district LIKE '%QUAN_1%' AND b.ward LIKE '%2%' AND b.number_of_basement = 2 AND
	(b.type LIKE '%TRANG_TRET%' OR b.type LIKE '%NGUYEN_CAN%' OR b.type LIKE '%NOI_THAT%')
	EXISTS (SELECT * FROM rentarea ra WHERE (b.buildingid = ra.buildingid
	AND ra.value >= 300 AND ra.value <= 500))
	AND b.rental >= 1 AND b.rental <=2
	AND ab.staffid = 2;