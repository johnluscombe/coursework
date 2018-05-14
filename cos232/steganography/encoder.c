#include <stdio.h>

int getImageOffset(FILE* file) {
    int imageOffset;
    fseek(file, 10, SEEK_SET);
    fread(&imageOffset, 4, 1, file);
    fseek(file, 0, SEEK_SET);
    return imageOffset;
}

void printImageOffset(FILE* file) {
    int imageOffset = getImageOffset(file);
    printf("Pixels start at: %d\n", imageOffset);
}

void printImageWidth(FILE* file) {
    int imageWidth;
    fseek(file, 18, SEEK_SET);
    fread(&imageWidth, 4, 1, file);
    printf("Width of image: %d\n", imageWidth);
    fseek(file, 0, SEEK_SET);
}

void printImageHeight(FILE* file) {
    int imageHeight;
    fseek(file, 22, SEEK_SET);
    fread(&imageHeight, 4, 1, file);
    printf("Height of image: %d\n", imageHeight);
    fseek(file, 0, SEEK_SET);
}

void printImageInfo(FILE* file) {
    printImageOffset(file);
    printImageWidth(file);
    printImageHeight(file);
}

void writeHeader(FILE* inFile, FILE* outFile) {
    int imageOffset = getImageOffset(inFile);

    for (int i = 0; i < imageOffset; i++) {
        unsigned char imageByte;
        fread(&imageByte, 1, 1, inFile);
        fwrite(&imageByte, 1, 1, outFile);
    }
}

unsigned char getBit(char byte, int distFromLSB) {
    int shiftedBit = byte >> distFromLSB;
    return (unsigned char)(shiftedBit & 1);
}

unsigned char setByte(unsigned char oldByte, unsigned char lsb) {
    int oldByteLSB = oldByte & 1;
    if (!oldByteLSB && lsb) {
        return (unsigned char)(oldByte + 1);
    } else if (oldByteLSB && !lsb) {
        return (unsigned char)(oldByte - 1);
    } else {
        return oldByte;
    }
}

void writeNullByte(FILE* inFile, FILE* outFile, int bytesRead) {
    char bytesWritten = 0;
    unsigned char oldImageByte, newImageByte;

    while (bytesWritten < 8) {
        fread(&oldImageByte, 1, 1, inFile);
        bytesRead++;

        if (bytesRead % 4 != 0) {
            newImageByte = setByte(oldImageByte, 0);
            fwrite(&newImageByte, 1, 1, outFile);
            bytesWritten++;
        } else {
            fwrite(&oldImageByte, 1, 1, outFile);
        }
    }
}

void writeBytesEncodedWithMessage(FILE* inFile, FILE* outFile, const char* secretMessagePtr) {
    char secretMessageChar = *secretMessagePtr;
    char bitIdx;
    int secretMessageIdx = 0;
    int bytesRead = 0;
    unsigned char oldImageByte, secretMessageBit, newImageByte;

    while (secretMessageChar != '\0') {
        bitIdx = 0;

        while (bitIdx < 8) {
            fread(&oldImageByte, 1, 1, inFile);
            bytesRead++;
            secretMessageBit = getBit(secretMessageChar, bitIdx);

            if (bytesRead % 4 != 0) {
                newImageByte = setByte(oldImageByte, secretMessageBit);
                fwrite(&newImageByte, 1, 1, outFile);
                bitIdx++;
            } else {
                fwrite(&oldImageByte, 1, 1, outFile);
            }
        }

        secretMessageIdx++;
        secretMessageChar = *(secretMessagePtr + secretMessageIdx);
    }

    writeNullByte(inFile, outFile, bytesRead);
}

void writeRestOfImage(FILE* inFile, FILE* outFile) {
    unsigned char oldImageByte;
    size_t bytesSuccessfullyRead = fread(&oldImageByte, 1, 1, inFile);
    while (bytesSuccessfullyRead > 0) {
        fwrite(&oldImageByte, 1, 1, outFile);
        bytesSuccessfullyRead = fread(&oldImageByte, 1, 1, inFile);
    }
}

void writeBitmapContents(char* inputFilePathPtr, char* outputFilePathPtr, const char* secretMessagePtr) {
    FILE* inFile = fopen(inputFilePathPtr, "r");
    FILE* outFile = fopen(outputFilePathPtr, "w");

    printImageInfo(inFile);
    writeHeader(inFile, outFile);
    writeBytesEncodedWithMessage(inFile, outFile, secretMessagePtr);
    writeRestOfImage(inFile, outFile);

    fclose(inFile);
    fclose(outFile);
}

int main(int argc, char* argv[]) {
    char* inputFilePath = argv[1];
    char* outputFilePath = argv[2];
    const char* secretMessage = argv[3];

    writeBitmapContents(inputFilePath, outputFilePath, secretMessage);

    return 0;
}