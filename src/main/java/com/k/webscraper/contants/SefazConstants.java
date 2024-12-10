package com.k.webscraper.contants;

public final class SefazConstants {

        private SefazConstants() {
            throw new AssertionError("Cannot instantiate Constants class");
        }

        public static final String SEFAZ_DOMAIN = "http://nfe.sefaz.go.gov.br/nfeweb/sites";
        public static final String SEFAZ_IDENTIFICATION = "/nfe/identificacao-tipo-consulta";
        public static final String SEFAZ_CONSULT = "/nfce/render/xml-consulta-completa";
        public static final String SEFAZ_RENDER = "/nfce/render/NFCe";

}
