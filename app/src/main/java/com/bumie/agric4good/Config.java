package com.bumie.agric4good;

public class Config {
    public static String CONVERSATION_ID = "CON-447593ed-c351-46ba-832d-372d86ded63c"; // TODO: set conversation Id

    public static Users getAlice() {
        return new Users(
                "Alice",
                "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MDc5MzM2NDAsImp0aSI6IjUyMjc1N2MwLTNkZTQtMTFlYi05ZTk0LWI5NzkwOTkxOWRhYyIsImV4cCI6MTYwODAyMDAzNiwiYWNsIjp7InBhdGhzIjp7Ii8qL3VzZXJzLyoqIjp7fSwiLyovY29udmVyc2F0aW9ucy8qKiI6e30sIi8qL3Nlc3Npb25zLyoqIjp7fSwiLyovZGV2aWNlcy8qKiI6e30sIi8qL2ltYWdlLyoqIjp7fSwiLyovbWVkaWEvKioiOnt9LCIvKi9hcHBsaWNhdGlvbnMvKioiOnt9LCIvKi9wdXNoLyoqIjp7fSwiLyova25vY2tpbmcvKioiOnt9fX0sImFwcGxpY2F0aW9uX2lkIjoiOTk2ZmZmMjgtYTkxYi00ZDgxLWI5MTEtNGMyM2FjYmRiZGIyIiwic3ViIjoiQWxpY2UifQ.to4eyhqGOCyskN4GkFz9cLirfK5fQjAhbugh68y0_E-28s9iieEeqd0FaMafzPYLIYWk5R8wlddrPFZf7ix-uTaSVAD1dnq9QsHtgl1eqfBfixn0BJupbNJOSunKxFHLaLyynYB_ag1b8GyeE0pG5GzWCbB9UuNQn-ZPFeXrXHkWIHP8jsc-e5jkEnsJeDtOCC7wwEDMt0n1PWMmhDMYbe8ouZpn6W7j7QXfNaUATAJCDO_YYJHeCOVGbV1OhzuRexByHhWWyohbnQaf3gfN7pclLPaxeiyVufc_T3_azm0A7uKfqvcqc5s3jC5ENtaYwNrlwyfwQTQkDKNjLh3DYg" // TODO: "set Alice JWT token"
        );
    }

    public static Users getBob() {
        return new Users(
                "Bob",
                "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MDc5MzM3MjYsImp0aSI6Ijg1NWQzYzkwLTNkZTQtMTFlYi05NmI1LWE5YzE3YWM4ZGY3NSIsImV4cCI6MTYwODAyMDEyMiwiYWNsIjp7InBhdGhzIjp7Ii8qL3VzZXJzLyoqIjp7fSwiLyovY29udmVyc2F0aW9ucy8qKiI6e30sIi8qL3Nlc3Npb25zLyoqIjp7fSwiLyovZGV2aWNlcy8qKiI6e30sIi8qL2ltYWdlLyoqIjp7fSwiLyovbWVkaWEvKioiOnt9LCIvKi9hcHBsaWNhdGlvbnMvKioiOnt9LCIvKi9wdXNoLyoqIjp7fSwiLyova25vY2tpbmcvKioiOnt9fX0sImFwcGxpY2F0aW9uX2lkIjoiOTk2ZmZmMjgtYTkxYi00ZDgxLWI5MTEtNGMyM2FjYmRiZGIyIiwic3ViIjoiQm9iIn0.MR2WNtAm8ivhQvNXTRf_Xv25BMRHicJ4rzwwvdeuNQ2TNzhIIxiVvm6xkaOk_eLsANQVGJe4NVMbsfwsIE_QrIxLp-ykK5Anvecg_vfCQfre_hN-Nd9uNw2n4V4crdVjiozQpqjXpWxC9NuAYxf0wEnkCdeFZFTWrkf6fceYiTGJ5YwS7pZpRo7o5RSweg2qgb5ayxxQRlk6DF8zyTh_bY5Ool6QKAuoXa2oyboXv3sovw4TxH4Uo3cCT0btnozcgvnj6ENJk5sBI5sTxhX0VMWeRCJuh9yJToJ2EsKhbh5aGrldiSkGXGcIJn4wT0jP4ajoW5M4xwSjxGb-rAExmg" // TODO: "set Bob JWT token"
        );
    }
}
