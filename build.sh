#! /bin/bash

SPRING_BOOT_PROJECT_DIR=$(pwd)
MODULES=("gateway" "posts" "timeline" "users")

# Function to compile and create Docker image for a module
compile_and_build_module() {
    local module=$1
    echo "Compiling and creating Docker image for $module..."
    cd "$SPRING_BOOT_PROJECT_DIR/$module" || exit
    ./mvnw clean
    ./mvnw spring-boot:build-image
    echo "Docker image for $module has been built successfully."
}

# Loop through each module, compile, and create Docker image
for module in "${MODULES[@]}"; do
    compile_and_build_module "$module"
done

echo "All Docker images have been built successfully."
