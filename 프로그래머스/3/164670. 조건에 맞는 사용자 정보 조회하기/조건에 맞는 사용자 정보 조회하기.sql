-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, CONCAT(u.CITY, ' ', u.STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소', CONCAT(
    SUBSTR(u.TLNO, 1, 3), 
    '-',                          
    SUBSTR(u.TLNO, 4, 4), 
    '-',                           
    SUBSTR(u.TLNO, 8)     
) AS '전화번호'
FROM USED_GOODS_USER u
JOIN (SELECT WRITER_ID, COUNT(*) AS num
      FROM USED_GOODS_BOARD
      GROUP BY WRITER_ID
      HAVING COUNT(*) >= 3
      ) as t
ON u.USER_ID = t.WRITER_ID
ORDER BY 1 DESC