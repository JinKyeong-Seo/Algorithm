SELECT a.TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, 
    b. CONTENTS, TO_CHAR(b.CREATED_DATE,'yyyy-mm-dd') AS CREATED_DATE
FROM USED_GOODS_BOARD a, USED_GOODS_REPLY b
WHERE a.BOARD_ID=b.BOARD_ID
    and TO_CHAR(a.CREATED_DATE,'yyyy-mm') LIKE '2022-10'
ORDER BY b.CREATED_DATE, a.TITLE;