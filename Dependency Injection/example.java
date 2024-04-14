public class ExampleTest {
  TestDoStuff() {
    MockDatabase mockDatabase = new MockDatabase();

    // MockDatabase is a subclass of DatabaseThingie, so we can
    // "inject" it here:
    Example example = new Example(mockDatabase);

    example.DoStuff();
    mockDatabase.AssertGetDataWasCalled();
  }
}

public class Example {
  private DatabaseThingie myDatabase;

  public Example() {
    myDatabase = new DatabaseThingie();
  }

  public Example(DatabaseThingie useThisDatabaseInstead) {
    myDatabase = useThisDatabaseInstead;
  }

  public void DoStuff() {
    ...
    myDatabase.GetData();
    ...
  }
}