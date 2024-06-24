INSERT INTO "analytics" (name, click, impression, CTR, CPC, CPA, conversion, bounce_rate, avg_time_on_site)
SELECT 'Advert from bloggers', 750, 30000, 2.5, 1.00, 40.00, 150.00, 40.00, '00:02:30'
WHERE NOT EXISTS (SELECT 1 FROM "analytics" WHERE name = 'Advert from bloggers');


INSERT INTO "analytics" (name, click, impression, CTR, CPC, CPA, conversion, bounce_rate, avg_time_on_site)
SELECT 'Luxuary cars HD', 1440, 45000, 3.20, 1.20, 45.00, 190.00, 32.00, '00:02:48'
WHERE NOT EXISTS (SELECT 1 FROM "analytics" WHERE name = 'Luxuary cars HD');

INSERT INTO "analytics" (name, click, impression, CTR, CPC, CPA, conversion, bounce_rate, avg_time_on_site)
SELECT 'Job online', 3500, 100000, 3.50, 1.75, 55.00, 350.00, 25.00, '00:04:00'
WHERE NOT EXISTS (SELECT 1 FROM "analytics" WHERE name = 'Job online');

INSERT INTO "analytics" (name, click, impression, CTR, CPC, CPA, conversion, bounce_rate, avg_time_on_site)
SELECT 'New tech in IT', 2800, 70000, 4.00, 2.00, 60.00, 280.00, 30.00, '00:03:30'
WHERE NOT EXISTS (SELECT 1 FROM "analytics" WHERE name = 'New tech in IT');


INSERT INTO "analytics" (name, click, impression, CTR, CPC, CPA, conversion, bounce_rate, avg_time_on_site)
SELECT 'Pop app into movie sites', 2280, 60000, 3.80, 1.80, 65.00, 240.00, 28.00, '00:03:12'
WHERE NOT EXISTS (SELECT 1 FROM "analytics" WHERE name = 'Pop app into movie sites');