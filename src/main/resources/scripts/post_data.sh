END_POINT="http://192.168.65.11:8080/products"

curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Kindle Paperwhite",
"brand": "Amazon",
"price": 129.99,
"stock": 100,
"category": "E-reader",
"description": "The all-new Kindle Paperwhite features a sleek, waterproof design, high-resolution display, and weeks of battery life.",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true
}'
echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data'
{
"name": "Echo Dot",
"brand": "Amazon",
"price": 49.99,
"stock": 100,
"stockUsed": 20,
"category": "Smart speaker",
"description": "The Echo Dot is a voice-controlled smart speaker with Alexa, perfect for any room.",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": false
}'
echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"id": 3,
"name": "Fire TV Stick",
"brand": "Amazon",
"price": 39.99,
"stock": 100,
"stockUsed": 20,
"category": "Streaming device",
"description": "The Fire TV Stick lets you stream all your favorite shows and movies from Amazon Prime, Netflix, Hulu, and more.",
}'

echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Instant Pot DUO60",
"brand": "Instant Pot",
"price": 79.95,
"stock": 100,
"stockUsed": 20,
"category": "Pressure cooker",
"description": "The Instant Pot DUO60 is a 7-in-1 pressure cooker that can also be used as a slow cooker, rice cooker, and more.",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true
}'


echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "LifeStraw Personal Water Filter",
"brand": "LifeStraw",
"price": 14.97,
"stock": 100,
"stockUsed": 20,
"category": "Water filter",
"description": "The LifeStraw is a portable water filter that removes 99.9999% of waterborne bacteria and parasites.",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": false
}'

echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Anker PowerCore 10000",
"brand": "Anker",
"price": 25.99,
"stock": 100,
"stockUsed": 20,
"category": "Portable charger",
"description": "The Anker PowerCore 10000 is a compact and lightweight portable charger with enough power to keep your devices charged on the go.",
}'


echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Bose QuietComfort 35 II",
"brand": "Bose",
"price": 349.00,
"stock": 100,
"stockUsed": 20,
"category": "Noise cancelling headphones",
"description": "The Bose QuietComfort 35 II is a pair of noise cancelling headphones with a comfortable and secure fit.",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true
}'



echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Tile Mate",
"brand": "Tile",
"price": 24.99,
"stock": 100,
"stockUsed": 20,
"category": "Tracking device",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true,
"description": "The Tile Mate is a small and versatile tracking device that helps you find your lost items."
}'



echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Fujifilm INSTAX Mini 9",
"brand": "Fujifilm",
"price": 69.99,
"stock": 100,
"stockUsed": 20,
"category": "Instant camera",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true,
"description": "Produce instant credit card size photos."
}'


echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Echo Dot",
"brand": "Amazon",
"price": 39.99,
"stock": 100,
"stockUsed": 20,
"category": "Voice Assistant",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": true,
"description": "The Echo Dot is an Alexa-controlled voice device that allows you to ask questions, play music, set alarms and much more."
}'


echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Echo Show 5",
"brand": "Amazon",
"price": 89.99,
"stock": 100,
"stockUsed": 20,
"category": "Voice Assistant",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": false,
"description": "The Echo Show 5 is an Alexa-controlled voice device with a 5.5-inch touchscreen that allows you to watch news, make video calls and much more."
}'


echo -e "\n"
curl --location $END_POINT --header 'Content-Type: application/json' --data '
{
"name": "Echo Auto",
"brand": "Amazon",
"price": 49.99,
"stock": 100,
"stockUsed": 20,
"category": "Voice Assistant",
"imageUrl": "url-img",
"discount": 0.2,
"enableDiscount": false,
"description": "The Echo Auto is an Alexa-controlled voice device for your car that allows you to play music, get directions and much more while driving."
}'