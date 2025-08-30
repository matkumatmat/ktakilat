package com.ktakilat.loan.http.face.google;

import java.io.Serializable;

public class GoolgePlaceDetailResp implements Serializable {
    private static final long serialVersionUID = -3826069290776583588L;
    public Result result = new Result();
    public String status;

    public class Geometry implements Serializable {
        private static final long serialVersionUID = -4545064712922891042L;
        public Location location = new Location();

        public class Location implements Serializable {
            private static final long serialVersionUID = 4947677818619650943L;
            public double lat;
            public double lng;

            public Location() {
            }
        }

        public Geometry() {
        }
    }

    public class Result implements Serializable {
        private static final long serialVersionUID = -8300926466692766913L;
        public Geometry geometry;

        public Result() {
            this.geometry = new Geometry();
        }
    }
}
