class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int product = 1;

        if (arr[n - 1] == 0 && (k % 2 != 0)) {
            return 0;
        }

        if (arr[n - 1] <= 0 && (k % 2 != 0)) {
            for (int i = n - 1; i >= n - k; i--) {
                product *= arr[i];
            }
            return product;
        }

        int left = 0;
        int right = n - 1;

        if (k % 2 != 0) {
            product *= arr[right];
            right--;
            k--;
        }

        while (k > 0) {
            int leftProduct = arr[left] * arr[left + 1];
            int rightProduct = arr[right] * arr[right - 1];

            if (leftProduct > rightProduct) {
                product *= leftProduct;
                left += 2;
            } else {
                product *= rightProduct;
                right -= 2;
            }
            k -= 2;
        }

        return product;
    }
}
