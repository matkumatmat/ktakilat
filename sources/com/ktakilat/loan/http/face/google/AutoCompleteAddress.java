package com.ktakilat.loan.http.face.google;

import java.io.Serializable;
import java.util.List;

public class AutoCompleteAddress implements Serializable {
    private static final long serialVersionUID = -5466946724816655109L;
    public String description;
    public String id;
    public String place_id;
    public String reference;
    public StructuredFormatting structured_formatting;
    public List<Terms> terms;
    public List<String> types;

    public class StructuredFormatting implements Serializable {
        private static final long serialVersionUID = 6939127768012440108L;
        public String main_text;
        public String secondary_text;

        public StructuredFormatting(String str) {
            this.main_text = str;
        }
    }

    public class Terms implements Serializable {
        private static final long serialVersionUID = 6349620964557887669L;
        public int offset;
        public String value;

        public Terms() {
        }
    }

    public AutoCompleteAddress(String str) {
        this.structured_formatting = new StructuredFormatting(str);
        this.description = str;
    }
}
