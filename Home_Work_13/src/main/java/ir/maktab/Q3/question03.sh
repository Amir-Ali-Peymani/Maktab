#!/bin/bash

create_files() {
    for i in {1..5}; do
        touch "file$i.txt"
    done
    echo "Five text files created."
}

append_hello() {
    for i in {1..5}; do
        echo "Hello world" >> "file$i.txt"
    done
    echo "Text 'Hello world' appended to all files."
}

replace_world_with_bash() {
    for i in {1..5}; do
        sed -i 's/world/bash/g' "file$i.txt"
    done
    echo "Text 'world' replaced with 'bash' in all files."
}

select_option() {
    echo "Select an option:"
    echo "1. Create five text files."
    echo "2. Append 'Hello world' to all files."
    echo "3. Replace 'world' with 'bash' in all files."
    echo "4. Exit."

    read -p "Enter your choice (1/2/3/4): " choice

    case "$choice" in
        1)
            create_files
            ;;
        2)
            append_hello
            ;;
        3)
            replace_world_with_bash
            ;;
        4)
            echo "Goodbye!"
            exit 0
            ;;
        *)
            echo "Invalid choice. Please select a valid option."
            ;;
    esac
}

while true; do
    select_option
done
