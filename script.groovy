// Groovy script to compile and run a C++ program
def cppFile = 'program.cpp'
def executable = 'program'

// Compile the C++ file
println "Compiling ${cppFile}..."
def compileResult = "g++ ${cppFile} -o ${executable}".execute()
compileResult.waitFor()

if (compileResult.exitValue() == 0) {
    println "Compilation successful. Running the program..."
    // Run the compiled executable
    def runResult = "./${executable}".execute()
    runResult.in.eachLine { line -> println line }
    runResult.waitFor()
    println "Program finished with exit code: ${runResult.exitValue()}"
} else {
    println "Compilation failed. Error:"
    compileResult.err.eachLine { line -> println line }
}
