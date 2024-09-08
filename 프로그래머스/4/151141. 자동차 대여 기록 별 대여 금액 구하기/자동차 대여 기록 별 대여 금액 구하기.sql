-- SELECT HISTORY_ID, (END_DATE-START_DATE+1) as day
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- WHERE CAR_ID IN (SELECT CAR_ID
--                  FROM CAR_RENTAL_COMPANY_CAR
--                  WHERE CAR_TYPE LIKE '트럭');

-- SELECT HISTORY_ID, 
--        CASE WHEN (END_DATE-START_DATE+1) >= 90 THEN  DAILY_FEE * (END_DATE-START_DATE+1) * 0.9
--        WHEN (END_DATE-START_DATE+1) >=30 THEN DAILY_FEE * (END_DATE-START_DATE+1) * 0.93
--        WHEN (END_DATE-START_DATE+1) >=7 THEN DAILY_FEE * (END_DATE-START_DATE+1) * 0.95
--        ELSE DAILY_FEE * (END_DATE-START_DATE+1) END AS FEE
-- FROM CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
-- WHERE C.CAR_ID=H.CAR_ID
-- AND CAR_TYPE='트럭'
-- ORDER BY FEE DESC, HISTORY_ID DESC;

SELECT HISTORY_ID,
       CASE WHEN (END_DATE-START_DATE+1) >= 90 THEN  DAILY_FEE * (END_DATE-START_DATE+1) * (100-(SELECT DISCOUNT_RATE
                                                                                                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                                                                 WHERE CAR_TYPE LIKE '트럭'
                                                                                                 AND DURATION_TYPE LIKE '90일 이상'))/100
       WHEN (END_DATE-START_DATE+1) >=30 THEN DAILY_FEE * (END_DATE-START_DATE+1) * (100-(SELECT DISCOUNT_RATE
                                                                                                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                                                                 WHERE CAR_TYPE LIKE '트럭'
                                                                                                 AND DURATION_TYPE LIKE '30일 이상'))/100
       WHEN (END_DATE-START_DATE+1) >=7 THEN DAILY_FEE * (END_DATE-START_DATE+1) * (100-(SELECT DISCOUNT_RATE
                                                                                                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                                                                 WHERE CAR_TYPE LIKE '트럭'
                                                                                                 AND DURATION_TYPE LIKE '7일 이상'))/100
       ELSE DAILY_FEE * (END_DATE-START_DATE+1) END AS FEE
FROM CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
WHERE C.CAR_ID=H.CAR_ID
AND CAR_TYPE='트럭'
ORDER BY FEE DESC, HISTORY_ID DESC;