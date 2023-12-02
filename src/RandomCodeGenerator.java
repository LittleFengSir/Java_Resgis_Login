import java.util.Random;

public class RandomCodeGenerator {
    private String generatedCode;

    public RandomCodeGenerator() {
        generateCode();
    }

    public void generateCode() {
        int codeLength = 4;
        StringBuilder code = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            int digit = random.nextInt(10);
            code.append(digit);
        }

        generatedCode = code.toString();
    }

    public String getGeneratedCode() {
        return generatedCode;
    }

    public static void main(String[] args) {
        // 示例用法
        RandomCodeGenerator codeGenerator = new RandomCodeGenerator();
        String generatedCode = codeGenerator.getGeneratedCode();
        System.out.println("Generated Code: " + generatedCode);
    }
}

