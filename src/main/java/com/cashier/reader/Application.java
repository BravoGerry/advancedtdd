package com.cashier.reader;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new ScannerIml(args);
        Display display = new SoutDisplay();
        CatalogInMemory catalog = oneEuroCatalog();

        Cashier cashier = new Cashier(catalog, display, scanner);

        for (int i =0; i < args.length; i++) {
            cashier.acquire();
        }
        cashier.sell();
    }

    private static CatalogInMemory oneEuroCatalog() {
        CatalogInMemory catalog = new CatalogInMemory();

        catalog.put("001", new Product("001", 1.00, false));
        catalog.put("002", new Product("002", 1.00, false));
        catalog.put("003", new Product("003", 1.00, false));
        return catalog;
    }

    private static class ScannerIml implements Scanner {
        private int  index = 0;
        private final String[] args;

        public ScannerIml(String[] args) {
            this.args = args;
        }


        @Override
        public String scan() {
            if (index < args.length) {
                return args[index++];
            }else{
                return null;
            }
        }
    }

    private static class SoutDisplay implements Display {
        @Override
        public void show(String price) {
            System.out.println(price);
        }
    }

}
