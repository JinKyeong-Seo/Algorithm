SELECT ORDER_ID,
       PRODUCT_ID,
       TO_CHAR(OUT_DATE,'yyyy-mm-dd') as OUT_DATE,
       CASE WHEN TO_CHAR(OUT_DATE,'yyyy-mm-dd') <= '2022-05-01' THEN '출고완료'
       WHEN OUT_DATE is null THEN '출고미정'
       ELSE '출고대기' END as 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID;