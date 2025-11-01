-- 코드를 작성해주세요
SELECT COUNT(*) as FISH_COUNT
FROM FISH_INFO I JOIN FISH_NAME_INFO N ON I.fish_type = N.fish_type
WHERE N.fish_name IN ('BASS', 'SNAPPER');