Chess Application

1. Its a simple app with a fixed size chess board - 8X8.
2. Two type of chess pieces - Rook and Knight.
3. Each chess piece has its own validation to check which moves it can make.
4. The abstract parent class Piece holds common method to validate any given coordinates.
3. Input validations are added to ensure valid inputs are passed on. 
4. The CoordMap class creates a work around for a bidirectional map. (eg: map position 'a1' to coordinates x=1, y=1 and vice-versa)

###### JAVA Version
* Java 8

###### BUILD AND RUN TESTS
* Run following command on Terminal to build and run tests
    >gradlew clean test --info               
* The test results will be available under
    > build/reports/tests/test/index.html 
    
###### EXTEND APPLICATION 
1. Add integration tests
2. Add remaining pieces
3. Add players to create a game
