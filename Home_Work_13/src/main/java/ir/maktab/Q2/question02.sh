#!/bin/bash

#!/bin/bash

pending_file="$HOME/todo_pending.txt"
completed_file="$HOME/todo_completed.txt"
deleted_file="$HOME/todo_deleted.txt"

add_task() {
    task="$1"
    echo "$task" >> "$pending_file"
    echo "Task added: $task"
}

view_pending_tasks() {
    if [ -f "$pending_file" ]; then
        echo "Pending Tasks:"
        cat "$pending_file"
    else
        echo "No pending tasks."
    fi
}

mark_task_completed() {
    task_number="$1"
    if [ -f "$pending_file" ]; then
        total_tasks=$(wc -l < "$pending_file")
        if [ "$task_number" -gt 0 ] && [ "$task_number" -le "$total_tasks" ]; then
            task=$(sed -n "${task_number}p" "$pending_file")
            sed -i "${task_number}d" "$pending_file"
            echo "$task" >> "$completed_file"
            echo "Task marked as completed: $task"
        else
            echo "Invalid task number. Please enter a valid task number to mark as completed."
        fi
    else
        echo "No pending tasks."
    fi
}

view_completed_tasks() {
    if [ -f "$completed_file" ]; then
        echo "Completed Tasks:"
        cat "$completed_file"
    else
        echo "No completed tasks."
    fi
}

delete_task() {
    task_number="$1"
    if [ -f "$pending_file" ]; then
        total_tasks=$(wc -l < "$pending_file")
        if [ "$task_number" -gt 0 ] && [ "$task_number" -le "$total_tasks" ]; then
            task=$(sed -n "${task_number}p" "$pending_file")
            sed -i "${task_number}d" "$pending_file"
            echo "$task" >> "$deleted_file"
            echo "Task deleted: $task"
        else
            echo "Invalid task number. Please enter a valid task number to delete."
        fi
    else
        echo "No pending tasks."
    fi
}

view_deleted_tasks() {
    if [ -f "$deleted_file" ]; then
        echo "Deleted Tasks:"
        cat "$deleted_file"
    else
        echo "No deleted tasks."
    fi
}

action="$1"
case "$action" in
    "add")
        task_to_add="$2"
        add_task "$task_to_add"
        ;;
    "view-pending")
        view_pending_tasks
        ;;
    "complete")
        task_number_to_complete="$2"
        mark_task_completed "$task_number_to_complete"
        ;;
    "view-completed")
        view_completed_tasks
        ;;
    "delete")
        task_number_to_delete="$2"
        delete_task "$task_number_to_delete"
        ;;
    "view-deleted")
        view_deleted_tasks
        ;;
    *)
        echo "Usage: $0 [add <task> | view-pending | complete <task_number> | view-completed | delete <task_number> | view-deleted]"
        exit 1
        ;;
esac
