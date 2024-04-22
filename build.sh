#! /bin/bash

SPRING_BOOT_PROJECT_DIR=$(pwd)
MODULES=("posts" "timeline" "users")

compile_and_build_module() {
    local module=$1
    echo "Natively compiling and creating Docker image for $module... (3-10 minutes depending on your hardware)"
    cd "$SPRING_BOOT_PROJECT_DIR/$module" || exit
    ./mvnw clean
    ./mvnw -Pnative spring-boot:build-image
    echo "Docker image for $module has been built successfully."
}

for module in "${MODULES[@]}"; do
    compile_and_build_module "$module"
done

echo "Compiling and creating Docker image for gateway..."
cd "$SPRING_BOOT_PROJECT_DIR/gateway" || exit
./mvnw clean install
docker build -t gateway:0.0.1-SNAPSHOT .
echo "Docker image for $module has been built successfully."

echo "All Docker images have been built successfully."
