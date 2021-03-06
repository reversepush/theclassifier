package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import org.junit.jupiter.api.Test;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstancesDataSetFactoryTest {

  @Test
  void createEmptyDatasetFactoryRightNumberOfAttributes() {

    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    int numberOfAttributes = expectedAttributesNamesList.size();
    int numberOfClassAttributes = 1;
    int numberOfExpectedAttributes = numberOfAttributes + numberOfClassAttributes;
    assertThat(dataSetActual.numAttributes()).isEqualTo(numberOfExpectedAttributes);
  }

  @Test
  void createEmptyDatasetFactoryRightNumberOfClasses() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    assertThat(dataSetActual.numClasses()).isEqualTo(expectedClassNamesList.size());
  }

  @Test
  void createEmptyDatasetFactoryCorrectAttribute() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    assertThat(dataSetActual.attribute(expectedAttributeNameNumberOne).name()).isEqualTo(expectedAttributeNameNumberOne);
  }

  @Test
  void createEmptyDatasetFactoryCorrectClass() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    assertThat(dataSetActual.attribute(InstancesDataSetFactory.CLASS_ATTRIBUTE_NAME).name()).isEqualTo(InstancesDataSetFactory.CLASS_ATTRIBUTE_NAME);
  }

  @Test
  void createNewRecordOfDataSetTypeRightNumberOfAttributes() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    double expectedValueNumberOne = 5.1;
    double expectedValueNumberTwo = 3.5;
    double[] values = {expectedValueNumberOne, expectedValueNumberTwo};
    DenseInstance newRecordOfDataSet = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    int numberOfExpectedAttributes = 2;
    assertThat(newRecordOfDataSet.numAttributes()).isEqualTo(numberOfExpectedAttributes);
  }

  @Test
  void createNewRecordOfDataSetTypeRightNumberOfClasses() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    double expectedValueNumberOne = 5.1;
    double expectedValueNumberTwo = 3.5;
    double[] values = {expectedValueNumberOne, expectedValueNumberTwo};
    DenseInstance newRecordOfDataSet = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    int numberOfExpectedClasses = 3;
    assertThat(newRecordOfDataSet.numClasses()).isEqualTo(numberOfExpectedClasses);
  }

  @Test
  void createNewRecordOfDataSetTypeRightNumberValues() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    double expectedValueNumberOne = 5.1;
    double expectedValueNumberTwo = 3.5;
    double[] values = {expectedValueNumberOne, expectedValueNumberTwo};
    DenseInstance newRecordOfDataSet = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    int numberOfExpectedValues = 2;
    assertThat(newRecordOfDataSet.numValues()).isEqualTo(numberOfExpectedValues);
  }

  @Test
  void createNewRecordOfDataSetTypeRightValues() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    double expectedValueNumberOne = 5.1;
    double expectedValueNumberTwo = 3.5;
    double[] values = {expectedValueNumberOne, expectedValueNumberTwo};
    DenseInstance newRecordOfDataSet = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    int indexOfNumberOneValues = 0;
    assertThat(newRecordOfDataSet.value(indexOfNumberOneValues)).isEqualTo(expectedValueNumberOne);
  }

  @Test
  void createNewRecordOfDataSetTypeRightValuesNumberTwo() {
    Instances dataSetActual = getInstancesFromInstancesDataSetFactory();
    double expectedValueNumberOne = 5.1;
    double expectedValueNumberTwo = 3.5;
    double[] values = {expectedValueNumberOne, expectedValueNumberTwo};
    DenseInstance newRecordOfDataSet = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    int indexOfNumberTwoValues = 1;
    assertThat(newRecordOfDataSet.value(indexOfNumberTwoValues)).isEqualTo(expectedValueNumberTwo);
  }

  private Instances getInstancesFromInstancesDataSetFactory() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    return InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
  }

  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectNumberOfValues() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    assertThat(mapActual.numValues()).isEqualTo(mapExpected.numValues());
  }

  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectNumberOfAttributes() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    assertThat(mapActual.numAttributes()).isEqualTo(mapExpected.numAttributes());
  }

  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectFirstAttributeValues() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    int attributeIndex = 0;
    assertThat(mapActual.value(attributeIndex)).isEqualTo(mapExpected.value(attributeIndex));
  }

  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectSecondAttributeValues() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    int attributeIndex = 1;
    assertThat(mapActual.value(attributeIndex)).isEqualTo(mapExpected.value(attributeIndex));
  }

  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectThirdAttributeValues() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    int attributeIndex = 2;
    assertThat(mapActual.value(attributeIndex)).isEqualTo(mapExpected.value(attributeIndex));
  }


  @Test
  void mapIrisFeaturesToDenseInstanceHaveCorrectFourthAttributeValues() throws IrisFeaturesFormatException {
    String sepalLengthString = "4.9";
    String sepalWidthString = "2.5";
    String petalLengthString = "4.5";
    String petalWidthString = "1.7";
    IrisFeatures irisFeaturesInput = IrisFeaturesFactory.createIrisFeatures(sepalLengthString, sepalWidthString, petalLengthString, petalWidthString);
    Instances dataSetActual = getIrisLikeInstance();
    double[] values = {Double.parseDouble(sepalLengthString), Double.parseDouble(sepalWidthString), Double.parseDouble(petalLengthString), Double.parseDouble(petalWidthString)};
    DenseInstance mapExpected = InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetActual, values);
    DenseInstance mapActual = InstancesDataSetFactory.map(irisFeaturesInput);
    int attributeIndex = 2;
    assertThat(mapActual.value(attributeIndex)).isEqualTo(mapExpected.value(attributeIndex));
  }


  private Instances getIrisLikeInstance() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    String expectedAttributeNameNumberThree = "numberThreeAttribute";
    String expectedAttributeNameNumberFour = "numberFourAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo, expectedAttributeNameNumberThree, expectedAttributeNameNumberFour);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    return InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
  }

}
