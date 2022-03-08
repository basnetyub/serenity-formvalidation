package getyourlawyer.model;

public record CalculationData(String numberOfSeeds, String name, String time, TreeType treeType) {
    public enum TreeType {
        ONE("One"), TWO("Two"), THREE("Three"), NONE("");
        private final String name;

        TreeType(String name) {
            this.name = name;
        }

        public static TreeType getTreeType(String name) {
            for (TreeType treeType : TreeType.values()) {
                if (treeType.getName().equals(name)) {
                    return treeType;
                }
            }
            return NONE;
        }

        public String getName() {
            return name;
        }
    }
}

