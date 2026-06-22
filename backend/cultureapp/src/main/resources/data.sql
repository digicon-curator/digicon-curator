INSERT INTO story (title, description, category, color, image_url, lat, lng, region) VALUES
('한밭수목원의 사계', '대전 도심 속 자연을 담은 수목원, 계절마다 다른 얼굴을 보여줍니다.', '자연', '#22c55e', 'https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=800', 36.3504, 127.3845, '대전광역시'),
('군산 근대문화의 거리', '일제강점기 건축물이 그대로 남아있는 시간여행 같은 골목길.', '문화재', '#3b82f6', 'https://images.unsplash.com/photo-1578894381163-e72c17f2d45f?w=800', 35.9676, 126.7369, '군산시'),
('전주 한옥마을의 밤', '기와지붕 사이로 스며드는 전통의 향기를 느낄 수 있는 곳.', '전통', '#f59e0b', 'https://images.unsplash.com/photo-1528360983277-13d401cdc186?w=800', 35.8242, 127.1480, '전주시'),
('부산 감천문화마을', '알록달록한 계단식 마을, 부산의 마추픽추라 불리는 곳.', '문화재', '#ef4444', 'https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?w=800', 35.1796, 129.0756, '부산광역시');

INSERT INTO timeline_entry (year, title, text, story_id) VALUES
('1965', '수목원 조성 시작', '대전 도심 개발과 함께 시민 휴식공간으로 계획되었습니다.', 1),
('1999', '한밭수목원 정식 개장', '동원과 서원으로 나뉜 현재의 모습을 갖추게 되었습니다.', 1),
('1899', '군산항 개항', '근대 무역항으로서 군산의 역사가 시작되었습니다.', 2),
('1930', '일본식 건축물 다수 건립', '지금까지 남아있는 근대문화유산의 기틀이 마련되었습니다.', 2),
('1394', '전주 객사 건립', '조선시대 관아 건물로서의 역사가 시작되었습니다.', 3),
('2010', '한옥마을 관광 활성화', '전통 한옥 숙박, 체험 프로그램이 본격적으로 늘어났습니다.', 3),
('1950', '감천마을 형성', '한국전쟁 피난민들이 모여 살며 마을이 형성되었습니다.', 4),
('2009', '마을미술 프로젝트', '주민과 예술가들이 협업하여 지금의 색채를 입혔습니다.', 4);

INSERT INTO category_image (category, image_url) VALUES
('문화재', 'https://images.unsplash.com/photo-1578894381163-e72c17f2d45f?w=800'),
('문화재', 'https://images.unsplash.com/photo-1564399579883-451a5d44ec08?w=800'),
('문화재', 'https://images.unsplash.com/photo-1528360983277-13d401cdc186?w=800'),
('축제', 'https://images.unsplash.com/photo-1533174072545-7a4b6ad7a6c3?w=800'),
('축제', 'https://images.unsplash.com/photo-1496337589254-7e19d01cec44?w=800'),
('축제', 'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=800'),
('전통시장', 'https://images.unsplash.com/photo-1555396273-367ea4eb4db5?w=800'),
('전통시장', 'https://images.unsplash.com/photo-1519676867240-f03562e64548?w=800'),
('전통시장', 'https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=800'),
('특화거리', 'https://images.unsplash.com/photo-1477959858617-67f85cf4f1df?w=800'),
('특화거리', 'https://images.unsplash.com/photo-1480714378408-67cf0d13bc1b?w=800'),
('특화거리', 'https://images.unsplash.com/photo-1449824913935-59a10b8d2000?w=800'),
('기타', 'https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?w=800'),
('기타', 'https://images.unsplash.com/photo-1488085061387-422e29b40080?w=800'),
('향토문화', 'https://images.unsplash.com/photo-1528360983277-13d401cdc186?w=800'),
('향토문화', 'https://images.unsplash.com/photo-1564399579883-451a5d44ec08?w=800'),
('행사', 'https://images.unsplash.com/photo-1533174072545-7a4b6ad7a6c3?w=800'),
('행사', 'https://images.unsplash.com/photo-1496337589254-7e19d01cec44?w=800'),
('공연', 'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=800'),
('공연', 'https://images.unsplash.com/photo-1429962714451-bb934ecdc4ec?w=800');