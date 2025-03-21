SELECT b.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES*PRICE) as SALES
FROM BOOK b, BOOK_SALES s, AUTHOR a
WHERE b.BOOK_ID = s.BOOK_ID
AND b.AUTHOR_ID = a.AUTHOR_ID
AND TO_CHAR(SALES_DATE,'yyyymm')='202201'
GROUP BY b.AUTHOR_ID, AUTHOR_NAME, CATEGORY
ORDER BY b.AUTHOR_ID, CATEGORY desc;