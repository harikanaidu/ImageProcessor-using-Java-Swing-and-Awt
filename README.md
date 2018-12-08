# ImageProcessor-using-Java-Swing-and-Awt
A web page that allows user to choose an image from the dataset and perform operations like converting the image to grayscale, negative, mirror image etc.

Working:
Once an image is selected from the JList, the selected value is compared with the string and the image is pasted in TWO different paths, one in the current folder and the other in a different folder in your PC.
Among the two paths, one serves as an input image file and the other as an output image file, hence making sure that the image is not being overwritten and the original image is preserved.
*Before running the code, make sure that the secong path is set to a different folder in your PC.*

There are five images in the dataset namely CuteCat, FierceFox, Teddylady, Vortex and Vacay listed in a JList, that appear on the webpage on clicking below the label.
On selecting an image, the user can select the different filters to be applied on the image and view the processed image or the original image in a window.
