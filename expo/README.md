# Expo City (Unreal Engine 8D) - Proje Mimari ve API

## Genel Bakış
Bu dizin, Unreal Engine 8D ile geliştirilecek olan Expo City projesinin mimarisini, asset şemasını ve Supabase REST API ile entegrasyon sürecini açıklamaktadır.

## Dizin Yapısı
- `/Assets` : 3D modeller, ses ve materyaller
- `/Blueprints` : Blueprint örnekleri (aşağıda detaylı)
- `/API` : Supabase REST API ile iletişim katmanı

## Asset Şeması
Her bir asset:
- `id` (string)
- `type` (ör: model, texture, sound)
- `metadata` (JSON), pozisyon, owner, vb.

## Supabase REST API
- `GET /assets` : Asset listesini döner
- `POST /assets` : Yeni asset ekler
- `GET /user/{id}` : Kullanıcı detayları

## Blueprint Örnekleri
Örnek: Tıklanabilir asset görüntüleyici

...

## Ek Notlar
Bu doküman geliştirme süresince güncellenecektir.
