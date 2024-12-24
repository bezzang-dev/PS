SELECT 
    MP.MEMBER_NAME,
    RR.REVIEW_TEXT,
    date_format(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM 
    REST_REVIEW RR
JOIN 
    MEMBER_PROFILE MP
    ON RR.MEMBER_ID = MP.MEMBER_ID
WHERE 
    RR.MEMBER_ID = (
        SELECT 
            MEMBER_ID
        FROM 
            REST_REVIEW
        GROUP BY 
            MEMBER_ID
        ORDER BY 
            COUNT(*) DESC
        LIMIT 1
    )
ORDER BY 
    RR.REVIEW_DATE ASC,
    RR.REVIEW_TEXT ASC;
