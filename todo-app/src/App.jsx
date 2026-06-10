import { useState } from "react";

export default function App() {
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState("");
  const [editIndex, setEditIndex] = useState(null);
  const [editText, setEditText] = useState("");

  const addTodo = () => {
    if (input.trim() === "") return;
    setTodos([...todos, { text: input, completed: false }]);
    setInput("");
  };

  const toggleTodo = (index) => {
    const updated = [...todos];
    updated[index].completed = !updated[index].completed;
    setTodos(updated);
  };

  const deleteTodo = (index) => {
    setTodos(todos.filter((_, i) => i !== index));
  };

  const deleteAll = () => {
    setTodos([]);
  };

  const startEdit = (index) => {
    setEditIndex(index);
    setEditText(todos[index].text);
  };

  const saveEdit = () => {
    if (editText.trim() === "") return;
    const updated = [...todos];
    updated[editIndex].text = editText;
    setTodos(updated);
    setEditIndex(null);
  };

  return (
    <div style={styles.page}>
      <div style={styles.appWrapper}>
        <div style={styles.logo}>To Do App</div>
        <h1 style={styles.subtitle}>Stay organized. Stay productive.</h1>

        <div style={styles.inputRow}>
          <input
            type="text"
            placeholder="Add a new task..."
            value={input}
            onChange={(e) => setInput(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && addTodo()}
            style={styles.input}
          />
          <button onClick={addTodo} style={styles.addBtn}>Add</button>
          <button onClick={deleteAll} style={styles.deleteAllBtn}>Delete All</button>
        </div>

        <ul style={styles.list}>
          {todos.map((todo, index) => (
            <li key={index} style={styles.todoItem}>
              {editIndex === index ? (
                <>
                  <input
                    value={editText}
                    onChange={(e) => setEditText(e.target.value)}
                    onKeyDown={(e) => {
                      if (e.key === "Enter") saveEdit();
                      if (e.key === "Escape") setEditIndex(null);
                    }}
                    autoFocus
                    style={styles.editInput}
                  />
                  <button onClick={saveEdit} style={styles.saveBtn}>Save</button>
                  <button onClick={() => setEditIndex(null)} style={styles.cancelBtn}>Cancel</button>
                </>
              ) : (
                <>
                  <label style={styles.todoLeft}>
                    <input
                      type="checkbox"
                      checked={todo.completed}
                      onChange={() => toggleTodo(index)}
                    />
                    <span
                      style={{
                        marginLeft: 12,
                        textDecoration: todo.completed ? "line-through" : "none",
                        color: todo.completed ? "#9ca3af" : "#111827",
                        fontSize: 18
                      }}
                    >
                      {todo.text}
                    </span>
                  </label>

                  <div style={{ display: "flex", gap: 8 }}>
                    <button onClick={() => startEdit(index)} style={styles.editBtn}>✎</button>
                    <button onClick={() => deleteTodo(index)} style={styles.deleteBtn}>✕</button>
                  </div>
                </>
              )}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

const styles = {
  page: {
    minHeight: "100vh",
    width: "100vw",
    background: "linear-gradient(120deg,#4f46e5,#9333ea,#ec4899)",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    fontFamily: "Segoe UI, sans-serif"
  },

  appWrapper: {
    width: "100%",
    maxWidth: 700,
    background: "rgba(255,255,255,0.95)",
    padding: 40,
    borderRadius: 24,
    boxShadow: "0 20px 60px rgba(0,0,0,0.25)"
  },

  logo: {
    textAlign: "center",
    fontSize: 46,
    fontWeight: 800,
    marginBottom: 6,
    color: "#4f46e5"
  },

  subtitle: {
    textAlign: "center",
    marginBottom: 40,
    color: "#6b7280",
    fontSize: 16
  },

  inputRow: {
    display: "flex",
    gap: 12,
    marginBottom: 28
  },

  input: {
    flex: 1,
    padding: 16,
    borderRadius: 14,
    border: "1px solid #e5e7eb",
    fontSize: 18
  },

  addBtn: {
    background: "#4f46e5",
    color: "white",
    border: "none",
    padding: "16px 22px",
    borderRadius: 14,
    cursor: "pointer"
  },

  deleteAllBtn: {
    background: "#ef4444",
    color: "white",
    border: "none",
    padding: "16px 22px",
    borderRadius: 14,
    cursor: "pointer"
  },

  list: { listStyle: "none", padding: 0 },

  todoItem: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    padding: 18,
    borderRadius: 16,
    background: "#f9fafb",
    marginBottom: 14
  },

  todoLeft: { display: "flex", alignItems: "center" },

  editBtn: {
    border: "none",
    background: "#f59e0b",
    color: "white",
    borderRadius: "50%",
    width: 36,
    height: 36,
    minWidth: 36,
    minHeight: 36,
    padding: 0,
    lineHeight: "36px",
    fontSize: 18,
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    cursor: "pointer"
  },

  deleteBtn: {
    border: "none",
    background: "#ef4444",
    color: "white",
    borderRadius: "50%",
    width: 36,
    height: 36,
    minWidth: 36,
    minHeight: 36,
    padding: 0,
    lineHeight: "36px",
    fontSize: 18,
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    cursor: "pointer"
  },

  editInput: {
    padding: 10,
    fontSize: 16,
    borderRadius: 10,
    border: "1px solid #ccc"
  },

  saveBtn: {
    background: "#10b981",
    color: "white",
    border: "none",
    padding: "8px 14px",
    borderRadius: 10,
    cursor: "pointer"
  },

  cancelBtn: {
    background: "#6b7280",
    color: "white",
    border: "none",
    padding: "8px 14px",
    borderRadius: 10,
    cursor: "pointer"
  }
};