package com.example.johnluscombe.faceservice;

public class DetectionData {

    public Face[] faces;

    public class Face {
        FaceAttributes attributes;

        public class FaceAttributes {
            FaceGender gender;
            FaceAge age;
            FaceEthnicity ethnicity;

            public class FaceGender {
                String value;
            }

            public class FaceAge {
                String value;
            }

            public class FaceEthnicity {
                String value;
            }
        }
    }
}
