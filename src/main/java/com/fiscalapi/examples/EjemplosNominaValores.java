// package com.fiscalapi.examples;

// public class EjemplosNominaValores {
//     public static void main(String[] args) {
//         // FiscalApiSettings settings = new FiscalApiSettings();
//         // settings.setDebugMode(true);
//         // settings.setApiUrl("https://test.fiscalapi.com");
//         // settings.setApiKey("sk_test_b4f8cc00_d02a_4ecc_a68a_f87ae970958c");
//         // settings.setTenant("275510ee-f64d-435a-9e92-1553d8f10a7e");

//         // // Sellos de KARLA FUENTE NOLASCO. Ver https://docs.fiscalapi.com/tax-files-info#codificacion-de-fiel-o-csd-en-base64
//         // final String base64Cer = "MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=";
//         // final String base64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=";
//         // final String password = "12345678a";

//         // final String escuelaKemperUrgateBase64Cer = "MIIFsDCCA5igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0MTYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTE0MzUxWhcNMjcwNTE4MTE0MzUxWjCB1zEnMCUGA1UEAxMeRVNDVUVMQSBLRU1QRVIgVVJHQVRFIFNBIERFIENWMScwJQYDVQQpEx5FU0NVRUxBIEtFTVBFUiBVUkdBVEUgU0EgREUgQ1YxJzAlBgNVBAoTHkVTQ1VFTEEgS0VNUEVSIFVSR0FURSBTQSBERSBDVjElMCMGA1UELRMcRUtVOTAwMzE3M0M5IC8gVkFEQTgwMDkyN0RKMzEeMBwGA1UEBRMVIC8gVkFEQTgwMDkyN0hTUlNSTDA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmecO6n2GS0zL025gbHGQVxznPDICoXzR2uUngz4DqxVUC/w9cE6FxSiXm2ap8Gcjg7wmcZfm85EBaxCx/0J2u5CqnhzIoGCdhBPuhWQnIh5TLgj/X6uNquwZkKChbNe9aeFirU/JbyN7Egia9oKH9KZUsodiM/pWAH00PCtoKJ9OBcSHMq8Rqa3KKoBcfkg1ZrgueffwRLws9yOcRWLb02sDOPzGIm/jEFicVYt2Hw1qdRE5xmTZ7AGG0UHs+unkGjpCVeJ+BEBn0JPLWVvDKHZAQMj6s5Bku35+d/MyATkpOPsGT/VTnsouxekDfikJD1f7A1ZpJbqDpkJnss3vQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAFaUgj5PqgvJigNMgtrdXZnbPfVBbukAbW4OGnUhNrA7SRAAfv2BSGk16PI0nBOr7qF2mItmBnjgEwk+DTv8Zr7w5qp7vleC6dIsZFNJoa6ZndrE/f7KO1CYruLXr5gwEkIyGfJ9NwyIagvHHMszzyHiSZIA850fWtbqtythpAliJ2jF35M5pNS+YTkRB+T6L/c6m00ymN3q9lT1rB03YywxrLreRSFZOSrbwWfg34EJbHfbFXpCSVYdJRfiVdvHnewN0r5fUlPtR9stQHyuqewzdkyb5jTTw02D2cUfL57vlPStBj7SEi3uOWvLrsiDnnCIxRMYJ2UA2ktDKHk+zWnsDmaeleSzonv2CHW42yXYPCvWi88oE1DJNYLNkIjua7MxAnkNZbScNw01A6zbLsZ3y8G6eEYnxSTRfwjd8EP4kdiHNJftm7Z4iRU7HOVh79/lRWB+gd171s3d/mI9kte3MRy6V8MMEMCAnMboGpaooYwgAmwclI2XZCczNWXfhaWe0ZS5PmytD/GDpXzkX0oEgY9K/uYo5V77NdZbGAjmyi8cE2B2ogvyaN2XfIInrZPgEffJ4AB7kFA2mwesdLOCh0BLD9itmCve3A1FGR4+stO2ANUoiI3w3Tv2yQSg4bjeDlJ08lXaaFCLW2peEXMXjQUk7fmpb5MNuOUTW6BE=";
//         // final String escuelaKemperUrgateBase64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS/AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucoZQObOaLUEm+I+QZ7Y8Giupo+F1XWkLvAsdk/uZlJcTfKLJyJbJwsQYbSpLOCLataZ4O5MVnnmMbfG//NKJn9kSMvJQZhSwAwoGLYDm1ESGezrvZabgFJnoQv8Si1nAhVGTk9FkFBesxRzq07dmZYwFCnFSX4xt2fDHs1PMpQbeq83aL/PzLCce3kxbYSB5kQlzGtUYayiYXcu0cVRu228VwBLCD+2wTDDoCmRXtPesgrLKUR4WWWb5N2AqAU1mNDC+UEYsENAerOFXWnmwrcTAu5qyZ7GsBMTpipW4Dbou2yqQ0lpA/aB06n1kz1aL6mNqGPaJ+OqoFuc8Ugdhadd+MmjHfFzoI20SZ3b2geCsUMNCsAd6oXMsZdWm8lzjqCGWHFeol0ik/xHMQvuQkkeCsQ28PBxdnUgf7ZGer+TN+2ZLd2kvTBOk6pIVgy5yC6cZ+o1Tloql9hYGa6rT3xcMbXlW+9e5jM2MWXZliVW3ZhaPjptJFDbIfWxJPjz4QvKyJk0zok4muv13Iiwj2bCyefUTRz6psqI4cGaYm9JpscKO2RCJN8UluYGbbWmYQU+Int6LtZj/lv8p6xnVjWxYI+rBPdtkpfFYRp+MJiXjgPw5B6UGuoruv7+vHjOLHOotRo+RdjZt7NqL9dAJnl1Qb2jfW6+d7NYQSI/bAwxO0sk4taQIT6Gsu/8kfZOPC2xk9rphGqCSS/4q3Os0MMjA1bcJLyoWLp13pqhK6bmiiHw0BBXH4fbEp4xjSbpPx4tHXzbdn8oDsHKZkWh3pPC2J/nVl0k/yF1KDVowVtMDXE47k6TGVcBoqe8PDXCG9+vjRpzIidqNo5qebaUZu6riWMWzldz8x3Z/jLWXuDiM7/Yscn0Z2GIlfoeyz+GwP2eTdOw9EUedHjEQuJY32bq8LICimJ4Ht+zMJKUyhwVQyAER8byzQBwTYmYP5U0wdsyIFitphw+/IH8+v08Ia1iBLPQAeAvRfTTIFLCs8foyUrj5Zv2B/wTYIZy6ioUM+qADeXyo45uBLLqkN90Rf6kiTqDld78NxwsfyR5MxtJLVDFkmf2IMMJHTqSfhbi+7QJaC11OOUJTD0v9wo0X/oO5GvZhe0ZaGHnm9zqTopALuFEAxcaQlc4R81wjC4wrIrqWnbcl2dxiBtD73KW+wcC9ymsLf4I8BEmiN25lx/OUc1IHNyXZJYSFkEfaxCEZWKcnbiyf5sqFSSlEqZLc4lUPJFAoP6s1FHVcyO0odWqdadhRZLZC9RCzQgPlMRtji/OXy5phh7diOBZv5UYp5nb+MZ2NAB/eFXm2JLguxjvEstuvTDmZDUb6Uqv++RdhO5gvKf/AcwU38ifaHQ9uvRuDocYwVxZS2nr9rOwZ8nAh+P2o4e0tEXjxFKQGhxXYkn75H3hhfnFYjik/2qunHBBZfcdG148MaNP6DjX33M238T9Zw/GyGx00JMogr2pdP4JAErv9a5yt4YR41KGf8guSOUbOXVARw6+ybh7+meb7w4BeTlj3aZkv8tVGdfIt3lrwVnlbzhLjeQY6PplKp3/a5Kr5yM0T4wJoKQQ6v3vSNmrhpbuAtKxpMILe8CQoo=";

//         // final String organicosNavezOsorioBase64Cer = "MIIF1DCCA7ygAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0MzkwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTI1NTE2WhcNMjcwNTE4MTI1NTE2WjCB+zEzMDEGA1UEAxQqT1JHQU5JQ09TINFBVkVaIE9TT1JJTyBTLkEgREUgQy5WIFNBIERFIENWMTMwMQYDVQQpFCpPUkdBTklDT1Mg0UFWRVogT1NPUklPIFMuQSBERSBDLlYgU0EgREUgQ1YxMzAxBgNVBAoUKk9SR0FOSUNPUyDRQVZFWiBPU09SSU8gUy5BIERFIEMuViBTQSBERSBDVjElMCMGA1UELRQcT9FPMTIwNzI2UlgzIC8gVkFEQTgwMDkyN0RKMzEeMBwGA1UEBRMVIC8gVkFEQTgwMDkyN0hTUlNSTDA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlAF4PoRqITQAEjFBzzfiT/NSN2yvb7Iv1ZMe4qD7tBxBxazRCx+GnimfpR+eaM744RlRDUj+hZfWcsOMn+q65UEIP+Xq5V1NbO1LZDse9uG1fLLSmptfKjyfvTtmBNYBjC3G6YmRv5qVw81CIS4aQOSMXKD+lrxjmRUhV9EAtXVoqGxvyDKeeX4caKuRz8mlrnR8/SMbnpobe5BNoXPrpDbEypemiJXe40pjsltY0RV3b0W0JtJQABUwZ9xn0lPYHY2q7IxYfohibv+o9ldXOXY6tivBZFfbGQSUp7CevC55+Y6uqh35Pi1o0nt/vBVgUOVPNM8d4TvGbXsE0G2J7QIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAFp52XykMXfFUtjQqA2zzLPrPIDSMEpkm1vWY0qfz2gC2TlVpbDCWH2vFHpP8D14OifXOmYkws2cvLyE0uBN6se4zXxVHBpTEq+93rvu/tjvMU6r7DISDwB0EX5kmKIFcOugET3/Eq1mxZ6mrI0K26RaEUz+HVyR0EQ2Ll5CLExDkPYV/am0gynhn6QPkxPNbcbm77PEIbH7zc+t7ZB5sgQ6LnubgnKNZDn8bNhkuM1jqFkh7h0owhlJrOvATgrDSLnrot8FoLFkrWQD4uA5udGRwXn5QWx0QM5ScNiSgSRilSFEyXn6rH/CJLO05Sx5OwJJTaxFbAyOXnoNdPMzbQAziaW78478nCNZVSrKWpjwWpScirtM2zcQ9fywd/a3CG66Ff29zasfhHJCp29TIjj1OURp6l1CKc16+UxjuVJ1z5Xh7v3s8S2gtmuYP1sUXPvAEYuVp9CFW87QVMtl3+nGlyJEzSAW/yaps9ua5RmyJK0Mjk1zyXjOJoIY75CIOMN8oqVAxmLJg5XftXJSekGpxybw9aq9qOJdmxVcZoAFaYg4MAdKViBoYxfWfEm4q/ihRz4asnzLp9NJWTXN1YH94rJrK7JSEq820flgr1kiL7z7n1rgWMvhJH9nHriG3yRkno/8OdLJxOSXd7MKZfZx0EWDX8toqWyE7zia8aPM=";
//         // final String organicosNavezOsorioBase64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS8AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRFLOMmsAaFFEdAecnfgJf0IlyJpvyNOGiSwXgY6uZtS0QJmmupWTlQATxbN4xeN7csx7yCMYxMiWXLyTbjVIWzzsFVKHbsxCudz6UDqMZ3aXEEPDDbPECXJC4FxqzuUgifN4QQuIvxfPbk23m3Vtqu9lr/xMrDNqLZ4RiqY2062kgQzGzekq8CSC97qBAbb8SFMgakFjeHN0JiTGaTpYCpGbu4d+i3ZrQ0mlYkxesdvCLqlCwVM0RTMJsNQ8vpBpRDzH372iOTLCO/gXtV8pEsxpUzG9LSUBo7xSMd1/lcfdyqVgnScgUm8/+toxk6uwZkUMWWvp7tqrMYQFYdR5CjiZjgAWrNorgMmawBqkJU6KQO/CpXVn99U1fANPfQoeyQMgLt35k0JKynG8MuWsgb4EG9Z6sRmOsCQQDDMKwhBjqcbEwN2dL4f1HyN8wklFCyYy6j1NTKU2AjRMXVu4+OlAp5jpjgv08RQxEkW/tNMSSBcpvOzNr64u0M692VA2fThR3UMQ/MZ2yVM6yY3GgIu2tJmg08lhmkoLpWZIMy7bZjj/AEbi7B3wSF4vDYZJcr/Djeezm3MMSghoiOIRSqtBjwf7ZjhA2ymdCsrzy7XSMVekT0y1S+ew1WhnzUNKQSucb6V2yRwNbm0EyeEuvVyHgiGEzCrzNbNHCfoFr69YCUi8itiDfiV7/p7LJzD8J/w85nmOkI/9p+aZ2EyaOdThqBmN4CtoDi5ixz/1EElLn7KVI4d/DZsZ4ZMu76kLAy94o0m6ORSbHX5hw12+P5DgGaLu/Dxd9cctRCkvcUdagiECuKGLJpxTJvEBQoZqUB8AJFgwKcNLl3Z5KAWL5hV0t1h8i3N4HllygqpfUSQMLWCtlGwdI4XGlGI5CmnjrL2Uj8sj9C0zSNqZVnAXFMV9f2ND9W6YJqfU89BQ6Y4QQRMGjXcVF7c78bn5r6zI+Qv2QKm3YiGCfuIa64B+PB/BdithpOuBPn5X5Zxc8ju/kYjJk7sau7VtKJseGOJ1bqOq99VzaxoHjzoJgthLHtni9WtGAnnQy7GMWGW4Un2yObHCxvQxx/rIZEaQiCGfRXOcZIZuXBe5xeHJFGrekDxu3YyumEnLWvsirDF3qhpUtxqvbkTuZw2xT3vTR+oWZpSEnYTd3k/09Eb0ovOPLkbhvcvCEeoI91EJvU+KI4Lm7ZsuTUSpECrHiS3uPOjboCigOWGayKzUHUICNrGK0zxgZXhhl6V7y9pImRl34ID/tZhr3veW4pQKgscv6sQjGJzaph2oCP7uZC6arGWcFpc2pgfBcobmOXYPWKskU3eWKClHBJnJ8MoOru+ObOb+izPhINHOmzP26TnKzFxdZiL+onxjadPYslcLtqlmOYpb/5hHgGOvitLhCLHCp0gYNB2uzj0sVxNs3k7k43KrlO5L6gp1KVaIw2a1yZzOCqDWWcePfKM3Mii9JdVyfHZLRRjFCQiOYo41AltHU+9IcaoT4J/j7pKw5tnlu2VaMlnN0dISpoq/ak0m4YjTd3XdRQeH9ktWmclkc65LdLKf9hIqjVqvOhQUJYkuT7OPgr+o7Z9BnClXMz1/CYWftwQE=";

//         // FiscalApiClient client = FiscalApiClient.create(settings);

//         // LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // // Crear nómina ordinaria por valores
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("FUNK671228PH6");
//     //     issuer.setLegalName("KARLA FUENTE NOLASCO");
//     //     issuer.setTaxRegimeCode("621");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(base64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(base64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("EKU9003173C9");
//     //     recipient.setLegalName("ESCUELA KEMPER URGATE");
//     //     recipient.setZipCode("42501");
//     //     recipient.setTaxRegimeCode("601");
//     //     recipient.setCfdiUseCode("CP01");
//     //     recipient.setEmail("someone@somewhere.com");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101MNEXXXA8");
//     //     employeeData.setSocialSecurityNumber("04078873454");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2024-08-18T00:00:00"));
//     //     employeeData.setSeniority("P54W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("02");
//     //     employeeData.setEmployeeNumber("123456789");
//     //     employeeData.setDepartment("GenAI");
//     //     employeeData.setPosition("Sr Software Engineer");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("05");
//     //     employeeData.setSatBankId("012");
//     //     employeeData.setBaseSalaryForContributions(OptUtil.parseBigDecimal("282.50"));
//     //     employeeData.setIntegratedDailySalary(OptUtil.parseBigDecimal("2626.23"));
//     //     employeeData.setSatPayrollStateId("JAL");

//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2025-08-30T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2025-07-31T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2025-08-30T00:00:00"));
//     //     payroll.setDaysPaid(30);
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("1003");
//     //     e1.setConcept("Sueldo nominal");
//     //     e1.setTaxedAmount(OptUtil.parseBigDecimal("95030.00"));
//     //     e1.setExemptAmount(OptUtil.parseBigDecimal("0"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("005");
//     //     e2.setCode("5913");
//     //     e2.setConcept("Fondo de Ahorro Aportación Patrón");
//     //     e2.setTaxedAmount(OptUtil.parseBigDecimal("0"));
//     //     e2.setExemptAmount(OptUtil.parseBigDecimal("0"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("038");
//     //     e3.setCode("1885");
//     //     e3.setConcept("Bono Ingles");
//     //     e3.setTaxedAmount(OptUtil.parseBigDecimal("14254.50"));
//     //     e3.setExemptAmount(OptUtil.parseBigDecimal("0"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("029");
//     //     e4.setCode("1941");
//     //     e4.setConcept("Vales Despensa");
//     //     e4.setTaxedAmount(OptUtil.parseBigDecimal("0"));
//     //     e4.setExemptAmount(OptUtil.parseBigDecimal("3439"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("038");
//     //     e5.setCode("1824");
//     //     e5.setConcept("Herramientas Teletrabajo (telecom y prop. electri)");
//     //     e5.setTaxedAmount(OptUtil.parseBigDecimal("273"));
//     //     e5.setExemptAmount(OptUtil.parseBigDecimal("0"));

//     //     PayrollEarning e6 = new PayrollEarning();
//     //     e6.setEarningTypeCode("002");
//     //     e6.setCode("5050");
//     //     e6.setConcept("Exceso de subsidio al empleo");
//     //     e6.setTaxedAmount(OptUtil.parseBigDecimal("0"));
//     //     e6.setExemptAmount(OptUtil.parseBigDecimal("0"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);
//     //     earnings.add(e6);

//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("5050");
//     //     op1.setConcept("exceso de subsidio al empleo");
//     //     op1.setAmount(OptUtil.parseBigDecimal("0"));
//     //     op1.setSubsidyCaused(OptUtil.parseBigDecimal("0"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("5003");
//     //     d1.setConcept("ISR Causado");
//     //     d1.setAmount(OptUtil.parseBigDecimal("27645"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("004");
//     //     d2.setCode("5910");
//     //     d2.setConcept("Fondo de ahorro Empleado Inversión");
//     //     d2.setAmount(OptUtil.parseBigDecimal("4412.46"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("004");
//     //     d3.setCode("5914");
//     //     d3.setConcept("Fondo de Ahorro Patrón Inversión");
//     //     d3.setAmount(OptUtil.parseBigDecimal("4412.46"));

//     //     PayrollDeduction d4 = new PayrollDeduction();
//     //     d4.setDeductionTypeCode("004");
//     //     d4.setCode("1966");
//     //     d4.setConcept("Contribución póliza exceso GMM");
//     //     d4.setAmount(OptUtil.parseBigDecimal("519.91"));

//     //     PayrollDeduction d5 = new PayrollDeduction();
//     //     d5.setDeductionTypeCode("004");
//     //     d5.setCode("1934");
//     //     d5.setConcept("Descuento Vales Despensa");
//     //     d5.setAmount(OptUtil.parseBigDecimal("1"));

//     //     PayrollDeduction d6 = new PayrollDeduction();
//     //     d6.setDeductionTypeCode("004");
//     //     d6.setCode("1942");
//     //     d6.setConcept("Vales Despensa Electrónico");
//     //     d6.setAmount(OptUtil.parseBigDecimal("3439"));

//     //     PayrollDeduction d7 = new PayrollDeduction();
//     //     d7.setDeductionTypeCode("001");
//     //     d7.setCode("1895");
//     //     d7.setConcept("IMSS");
//     //     d7.setAmount(OptUtil.parseBigDecimal("2391.13"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);
//     //     payrollDeductions.add(d4);
//     //     payrollDeductions.add(d5);
//     //     payrollDeductions.add(d6);
//     //     payrollDeductions.add(d7);

//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(OptUtil.parseLocalDateTime("2026-02-09T10:00:00"));
//     //     invoice.setTypeCode("N");
//     //     invoice.setExpeditionZipCode("42501");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setDate(OptUtil.parseLocalDateTime("2026-02-09T10:00:00"));
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina asimilados por valores
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setOriginEmployerTin("EKU9003173C9");
//     //     issuer.setEmployerData(employerData);

//         // // Certificados del emisor
//         // List<TaxCredential> credentials = new ArrayList<>();

//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(escuelaKemperUrgateBase64Cer);
//         // cer.setFileType(0); // 0 = Certificado (.cer)
//         // cer.setPassword(password);

//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(escuelaKemperUrgateBase64Key);
//         // key.setFileType(1); // 1 = Clave privada (.key)
//         // key.setPassword(password);

//         // credentials.add(cer);
//         // credentials.add(key);

//         // issuer.setTaxCredentials(credentials);

//     // // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("CACX7605101P8");
//     //     recipient.setLegalName("XOCHILT CASAS CHAVEZ");
//     //     recipient.setZipCode("36257");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSatContractTypeId("09");
//     //     employeeData.setSatUnionizedStatusId("No");
//     //     employeeData.setSatTaxRegimeTypeId("09");
//     //     employeeData.setEmployeeNumber("00002");
//     //     employeeData.setDepartment("ADMINISTRACION");
//     //     employeeData.setPosition("DIRECTOR DE ADMINISTRACION");
//     //     employeeData.setSatPaymentPeriodicityId("99");
//     //     employeeData.setSatBankId("012");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setSatPayrollStateId("CMX");
//     //     recipient.setEmployeeData(employeeData);

//     // // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-02T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-01T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-02T00:00:00"));
//     //     payroll.setDaysPaid(1);

//     // // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("046");
//     //     e1.setCode("010046");
//     //     e1.setConcept("INGRESOS ASIMILADOS A SALARIOS");
//     //     e1.setTaxedAmount(new BigDecimal("111197.73"));
//     //     e1.setExemptAmount(new BigDecimal("0.00"));

//     //     earnings.add(e1);

//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     // // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("020002");
//     //     d1.setConcept("ISR");
//     //     d1.setAmount(new BigDecimal("36197.73"));

//     //     payrollDeductions.add(d1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     // // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("06880");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con bonos fondo de ahorro y deducciones
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("Z0000001234");
//     //     issuer.setEmployerData(employerData);

//         // // Certificados del emisor
//         // List<TaxCredential> credentials = new ArrayList<>();

//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(escuelaKemperUrgateBase64Cer);
//         // cer.setFileType(0); // 0 = Certificado (.cer)
//         // cer.setPassword(password);

//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(escuelaKemperUrgateBase64Key);
//         // key.setFileType(1); // 1 = Clave privada (.key)
//         // key.setPassword(password);

//         // credentials.add(cer);
//         // credentials.add(key);

//         // issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101MNEXXXA8");
//     //     employeeData.setSocialSecurityNumber("0000000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2022-03-02T00:00:00"));
//     //     employeeData.setSeniority("P66W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatUnionizedStatusId("No");
//     //     employeeData.setSatTaxRegimeTypeId("02");
//     //     employeeData.setEmployeeNumber("111111");
//     //     employeeData.setSatJobRiskId("4");
//     //     employeeData.setSatPaymentPeriodicityId("02");
//     //     employeeData.setIntegratedDailySalary(OptUtil.parseBigDecimal("180.96"));
//     //     employeeData.setSatPayrollStateId("GUA");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Items
//     //     List<InvoiceItem> items = new ArrayList<>();

//     //     InvoiceItem item1 = new InvoiceItem();
//     //     item1.setItemCode("84111505");
//     //     item1.setItemSku("84111505");
//     //     item1.setQuantity(new BigDecimal("1"));
//     //     item1.setUnitOfMeasurementCode("ACT");
//     //     item1.setDescription("Pago de nómina");
//     //     item1.setUnitPrice(OptUtil.parseBigDecimal("1842.82"));
//     //     item1.setDiscount(OptUtil.parseBigDecimal("608.71"));
//     //     item1.setTaxObjectCode("01");

//     //     items.add(item1);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-11T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-05T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-11T00:00:00"));
//     //     payroll.setDaysPaid(7);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("SP01");
//     //     e1.setConcept("SUELDO");
//     //     e1.setTaxedAmount(OptUtil.parseBigDecimal("1210.30"));
//     //     e1.setExemptAmount(OptUtil.parseBigDecimal("0.00"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("010");
//     //     e2.setCode("SP02");
//     //     e2.setConcept("PREMIO PUNTUALIDAD");
//     //     e2.setTaxedAmount(new BigDecimal("121.03"));
//     //     e2.setExemptAmount(new BigDecimal("0.00"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("029");
//     //     e3.setCode("SP03");
//     //     e3.setConcept("MONEDERO ELECTRONICO");
//     //     e3.setTaxedAmount(new BigDecimal("0.00"));
//     //     e3.setExemptAmount(new BigDecimal("269.43"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("010");
//     //     e4.setCode("SP04");
//     //     e4.setConcept("PREMIO DE ASISTENCIA");
//     //     e4.setTaxedAmount(new BigDecimal("121.03"));
//     //     e4.setExemptAmount(new BigDecimal("0.00"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("005");
//     //     e5.setCode("SP54");
//     //     e5.setConcept("APORTACION FONDO AHORRO");
//     //     e5.setTaxedAmount(new BigDecimal("0.00"));
//     //     e5.setExemptAmount(new BigDecimal("121.03"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("ISRSUB");
//     //     op1.setConcept("Subsidio ISR para empleo");
//     //     op1.setAmount(new BigDecimal("0.0"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     BalanceCompensation balanceCompensation = new BalanceCompensation();
//     //     balanceCompensation.setFavorableBalance(new BigDecimal("0.0"));
//     //     balanceCompensation.setYear(2022);
//     //     balanceCompensation.setRemainingFavorableBalance(new BigDecimal("0.0"));

//     //     op1.setBalanceCompensation(balanceCompensation);

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("004");
//     //     d1.setCode("ZA09");
//     //     d1.setConcept("APORTACION FONDO AHORRO");
//     //     d1.setAmount(new BigDecimal("121.03"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("ISR");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("36.57"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("001");
//     //     d3.setCode("IMSS");
//     //     d3.setConcept("Cuota de Seguridad Social EE");
//     //     d3.setAmount(new BigDecimal("30.08"));

//     //     PayrollDeduction d4 = new PayrollDeduction();
//     //     d4.setDeductionTypeCode("004");
//     //     d4.setCode("ZA68");
//     //     d4.setConcept("DEDUCCION FDO AHORRO PAT");
//     //     d4.setAmount(new BigDecimal("121.03"));

//     //     PayrollDeduction d5 = new PayrollDeduction();
//     //     d5.setDeductionTypeCode("018");
//     //     d5.setCode("ZA11");
//     //     d5.setConcept("APORTACION CAJA AHORRO");
//     //     d5.setAmount(new BigDecimal("300.00"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);
//     //     payrollDeductions.add(d4);
//     //     payrollDeductions.add(d5);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setItems(items);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con horas extra
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P437W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("019");
//     //     e2.setCode("00100");
//     //     e2.setConcept("Horas Extra");
//     //     e2.setTaxedAmount(new BigDecimal("50.00"));
//     //     e2.setExemptAmount(new BigDecimal("50.00"));

//     //     List<PayrollEarningOvertime> overtimeList = new ArrayList<>();
//     //     PayrollEarningOvertime overtime1 = new PayrollEarningOvertime();
//     //     overtime1.setDays(1);
//     //     overtime1.setHoursTypeCode("01");
//     //     overtime1.setExtraHours(2);
//     //     overtime1.setAmountPaid(new BigDecimal("100.00"));
//     //     overtimeList.add(overtime1);

//     //     e2.setOvertime(overtimeList);

//     //     earnings.add(e1);
//     //     earnings.add(e2);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payroll.setEarnings(payrollEarnings);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200.00"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina con incapacidades
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P437W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.80"));
//     //     e1.setExemptAmount(new BigDecimal("2191.20"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200.00"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100.00"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     // Disabilities
//     //     List<PayrollDisability> disabilities = new ArrayList<>();

//     //     PayrollDisability disability1 = new PayrollDisability();
//     //     disability1.setDisabilityDays(1);
//     //     disability1.setDisabilityTypeCode("01");

//     //     disabilities.add(disability1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);
//     //     payroll.setDisabilities(disabilities);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con SNCF
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("OÑO120726RX3");
//     //     issuer.setLegalName("ORGANICOS ÑAVEZ OSORIO");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("27112029");
//     //     employerData.setSatFundSourceId("IP");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(organicosNavezOsorioBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(organicosNavezOsorioBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("CACX7605101P8");
//     //     recipient.setLegalName("XOCHILT CASAS CHAVEZ");
//     //     recipient.setZipCode("36257");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("80997742673");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2021-09-01"));
//     //     employeeData.setSeniority("P88W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("02");
//     //     employeeData.setEmployeeNumber("273");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("221.48"));
//     //     employeeData.setSatPayrollStateId("GRO");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-16T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-01T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-16T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("P001");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("3322.20"));
//     //     e1.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("038");
//     //     e2.setCode("P540");
//     //     e2.setConcept("Compensacion");
//     //     e2.setTaxedAmount(new BigDecimal("100.0"));
//     //     e2.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("038");
//     //     e3.setCode("P550");
//     //     e3.setConcept("Compensación Garantizada Extraordinaria");
//     //     e3.setTaxedAmount(new BigDecimal("2200.0"));
//     //     e3.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("038");
//     //     e4.setCode("P530");
//     //     e4.setConcept("Servicio Extraordinario");
//     //     e4.setTaxedAmount(new BigDecimal("200.0"));
//     //     e4.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("001");
//     //     e5.setCode("P506");
//     //     e5.setConcept("Otras Prestaciones");
//     //     e5.setTaxedAmount(new BigDecimal("1500.0"));
//     //     e5.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e6 = new PayrollEarning();
//     //     e6.setEarningTypeCode("001");
//     //     e6.setCode("P505");
//     //     e6.setConcept("Remuneración al Desempeño Legislativo");
//     //     e6.setTaxedAmount(new BigDecimal("17500.0"));
//     //     e6.setExemptAmount(new BigDecimal("0.0"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);
//     //     earnings.add(e6);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("o002");
//     //     op1.setConcept("Subsidio para el empleo efectivamente entregado al trabajador");
//     //     op1.setAmount(new BigDecimal("0.0"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("D002");
//     //     d1.setConcept("ISR");
//     //     d1.setAmount(new BigDecimal("4716.61"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("004");
//     //     d2.setCode("D525");
//     //     d2.setConcept("Redondeo");
//     //     d2.setAmount(new BigDecimal("0.81"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("001");
//     //     d3.setCode("D510");
//     //     d3.setConcept("Cuota Trabajador ISSSTE");
//     //     d3.setAmount(new BigDecimal("126.78"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("39074");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina extraordinaria
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P439W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("99");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("002");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Gratificación Anual (Aguinaldo)");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina separacion indemnización
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P439W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("99");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-05T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("023");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Pagos por separación");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("025");
//     //     e2.setCode("00900");
//     //     e2.setConcept("Indemnizaciones");
//     //     e2.setTaxedAmount(new BigDecimal("0.00"));
//     //     e2.setExemptAmount(new BigDecimal("500.00"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     // Severance
//     //     PayrollSeverance severance = new PayrollSeverance();
//     //     severance.setTotalPaid(new BigDecimal("10500.00"));
//     //     severance.setYearsOfService(1);
//     //     severance.setLastMonthlySalary(new BigDecimal("10000.00"));
//     //     severance.setAccumulableIncome(new BigDecimal("10000.00"));
//     //     severance.setNonAccumulableIncome(new BigDecimal("0.00"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payrollEarnings.setSeverance(severance);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina jubilación
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P439W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("99");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-05T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("039");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Jubilaciones, pensiones o haberes de retiro");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     // Retirement
//     //     PayrollRetirement retirement = new PayrollRetirement();
//     //     retirement.setTotalOneTime(new BigDecimal("10000.00"));
//     //     retirement.setAccumulableIncome(new BigDecimal("10000.00"));
//     //     retirement.setNonAccumulableIncome(new BigDecimal("0.00"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payrollEarnings.setRetirement(retirement);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina sin deducciones
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01"));
//     //     employeeData.setSeniority("P437W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);
        
//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina viáticos
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01T00:00:00"));
//     //     employeeData.setSeniority("P438W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-09-26T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-09-11T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-09-26T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("050");
//     //     e1.setCode("050");
//     //     e1.setConcept("Viaticos");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("3000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("081");
//     //     d1.setCode("081");
//     //     d1.setConcept("Ajuste en viaticos entregados al trabajador");
//     //     d1.setAmount(new BigDecimal("3000.00"));

//     //     payrollDeductions.add(d1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina subsidio causado al empleo
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01T00:00:00"));
//     //     employeeData.setSeniority("P437W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("02");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("007");
//     //     op1.setCode("0002");
//     //     op1.setConcept("ISR ajustado por subsidio");
//     //     op1.setAmount(new BigDecimal("145.80"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("107");
//     //     d1.setCode("D002");
//     //     d1.setConcept("Ajuste al Subsidio Causado");
//     //     d1.setAmount(new BigDecimal("160.35"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("D002");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("145.80"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setTin("EKU9003173C9");
//     //     issuer.setLegalName("ESCUELA KEMPER URGATE");
//     //     issuer.setTaxRegimeCode("601");

//     //     EmployerData employerData = new EmployerData();
//     //     employerData.setEmployerRegistration("B5510768108");
//     //     employerData.setOriginEmployerTin("URE180429TM6");
//     //     issuer.setEmployerData(employerData);

//     //     // Certificados del emisor
//     //     List<TaxCredential> credentials = new ArrayList<>();

//     //     TaxCredential cer = new TaxCredential();
//     //     cer.setBase64File(escuelaKemperUrgateBase64Cer);
//     //     cer.setFileType(0); // 0 = Certificado (.cer)
//     //     cer.setPassword(password);

//     //     TaxCredential key = new TaxCredential();
//     //     key.setBase64File(escuelaKemperUrgateBase64Key);
//     //     key.setFileType(1); // 1 = Clave privada (.key)
//     //     key.setPassword(password);

//     //     credentials.add(cer);
//     //     credentials.add(key);

//     //     issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setTin("XOJI740919U48");
//     //     recipient.setLegalName("INGRID XODAR JIMENEZ");
//     //     recipient.setZipCode("76028");
//     //     recipient.setTaxRegimeCode("605");
//     //     recipient.setCfdiUseCode("CN01");

//     //     EmployeeData employeeData = new EmployeeData();
//     //     employeeData.setCurp("XEXX010101HNEXXXA4");
//     //     employeeData.setSocialSecurityNumber("000000");
//     //     employeeData.setLaborRelationStartDate(OptUtil.parseLocalDateTime("2015-01-01T00:00:00"));
//     //     employeeData.setSeniority("P437W");
//     //     employeeData.setSatContractTypeId("01");
//     //     employeeData.setSatWorkdayTypeId("01");
//     //     employeeData.setSatTaxRegimeTypeId("03");
//     //     employeeData.setEmployeeNumber("120");
//     //     employeeData.setDepartment("Desarrollo");
//     //     employeeData.setPosition("Ingeniero de Software");
//     //     employeeData.setSatJobRiskId("1");
//     //     employeeData.setSatPaymentPeriodicityId("04");
//     //     employeeData.setSatBankId("002");
//     //     employeeData.setBankAccount("1111111111");
//     //     employeeData.setBaseSalaryForContributions(new BigDecimal("490.22"));
//     //     employeeData.setIntegratedDailySalary(new BigDecimal("146.47"));
//     //     employeeData.setSatPayrollStateId("JAL");
//     //     recipient.setEmployeeData(employeeData);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);
//     }
// }
